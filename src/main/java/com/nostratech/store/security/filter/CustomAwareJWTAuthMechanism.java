package com.nostratech.store.security.filter;

import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import io.quarkus.arc.Priority;
import io.quarkus.security.identity.IdentityProviderManager;
import io.quarkus.security.identity.SecurityIdentity;
import io.quarkus.security.identity.request.AuthenticationRequest;
import io.quarkus.smallrye.jwt.runtime.auth.JWTAuthMechanism;
import io.quarkus.vertx.http.runtime.security.ChallengeData;
import io.quarkus.vertx.http.runtime.security.HttpAuthenticationMechanism;
import io.quarkus.vertx.http.runtime.security.HttpCredentialTransport;
import io.smallrye.mutiny.Uni;
import io.vertx.ext.web.RoutingContext;

@Alternative
@Priority(value = 1)
@ApplicationScoped
public class CustomAwareJWTAuthMechanism implements HttpAuthenticationMechanism {

	@Inject
	JWTAuthMechanism  delegate;
	
	@Override
	public Uni<SecurityIdentity> authenticate(RoutingContext context, IdentityProviderManager identityProviderManager) {
        return delegate.authenticate(context, identityProviderManager);

	}

	@Override
	public Uni<ChallengeData> getChallenge(RoutingContext context) {
		return delegate.getChallenge(context);

	}

	@Override
	public Set<Class<? extends AuthenticationRequest>> getCredentialTypes() {
		return delegate.getCredentialTypes();

	}

	@Override
	public HttpCredentialTransport getCredentialTransport() {
		return delegate.getCredentialTransport();
	}
	


}
