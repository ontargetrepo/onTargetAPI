package com.ontarget.api.filter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.glassfish.jersey.message.internal.ReaderWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.ontarget.api.service.AuthorizationService;
import com.ontarget.constant.OnTargetConstant;

@Provider
public class AuthorizationFilter implements ContainerRequestFilter {
	private Logger logger = Logger.getLogger(AuthorizationFilter.class);

	@Autowired
	private AuthorizationService authorizationService;

	@Override
	public void filter(ContainerRequestContext request) {
		logger.info("base URI:: " + request.getUriInfo().getBaseUri());
		logger.info(request.getMethod());

		String path = request.getUriInfo().getPath();

		logger.info("path:: " + path);

		String openEndpointArr[] = OnTargetConstant.OPEN_RS_ENDPOINT.split(",");
		for (String openEndpoint : openEndpointArr) {
			if (path.startsWith(openEndpoint)) {
				return;
			}
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream in = request.getEntityStream();
		final StringBuilder b = new StringBuilder();
		try {
			if (in.available() > 0) {
				ReaderWriter.writeTo(in, out);

				byte[] requestEntity = out.toByteArray();
				String jsonPost = getJsonPostObj(b, requestEntity);

				if (jsonPost == null || jsonPost.trim().length() == 0) {
					logger.error("Empty json request");
					throw new WebApplicationException(unauthorizedResponse());
				}

				if (authenticate(jsonPost)) {
					request.setEntityStream(new ByteArrayInputStream(
							requestEntity));
					return;
				}
			}

		} catch (IOException ex) {
			ex.printStackTrace();
			throw new WebApplicationException(unauthorizedResponse());
		}

		throw new WebApplicationException(unauthorizedResponse());

	}

	private Response unauthorizedResponse() {
		ResponseBuilder builder = Response.status(Response.Status.UNAUTHORIZED)
				.entity("User cannot access the resource.");
		return builder.build();
	}

	private String getJsonPostObj(StringBuilder b, byte[] entity)
			throws IOException {
		if (entity.length == 0)
			return "";
		b.append(new String(entity)).append("\n");
		return b.toString();
	}

	private boolean authenticate(String jsonData) {
		try {
			logger.info("json post:: " + jsonData);

			ObjectMapper mapper = new ObjectMapper();

			JsonNode actualObj = mapper.readTree(jsonData);

			JsonNode baseRequestObj = actualObj.get("baseRequest");

			JsonNode userObjNode = baseRequestObj.get("loggedInUserId");
			Integer userId = userObjNode.getIntValue();

			JsonNode projectObjNode = baseRequestObj
					.get("loggedInUserProjectId");
			Integer projectId = projectObjNode.getIntValue();

			boolean authorized = authorizationService.validateUserOnProject(
					userId, projectId);
			logger.info("Authorized:: " + authorized);
			if (authorized) {
				return true;
			}
			// return false;
			// TODO: to pass request
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("System error");
		}
		return false;
	}

}