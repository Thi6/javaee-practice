package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.qa.domain.Account;
import com.qa.repository.AccountRepo;

@Path("/")
public class AccountEndpoints {
	@Inject
	AccountRepo repo;
	
	@GET
	@Path("/account")
	@Produces(MediaType.TEXT_PLAIN) // will return text
	public Response getAccount() {
		String hello = "Hello World";
		return Response.ok(hello).build();
	}
	
	@POST
	@Path("/account/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Account account) {
		Account a = repo.create(account);
		return Response.ok(a).build();
	}
	
}
