package ar.edu.ues21.algarrobo.admissioneventservice.config;

import ar.edu.ues21.algarrobo.admissioneventservice.model.kafka.StudentRecordEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.model.kafka.UserContactEvent;
import com.fasterxml.classmate.TypeResolver;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${admission-event-service.oauthserver}")
    private String baseAuthUrl;

    @Value("${admission-event-service.version}")
    private String appVersion;

    @Bean
    public Docket api(TypeResolver typeResolver) {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .securityContexts(Lists.newArrayList(securityContext()))
                .securitySchemes(Lists.newArrayList(securitySchema())).select()
                .apis(RequestHandlerSelectors.basePackage("ar.edu.ues21.algarrobo.admissioneventservice")).paths(PathSelectors.any())
                .build()
                .apiInfo(apiEndPointsInfo())
                .genericModelSubstitutes()
                .additionalModels(
                        typeResolver.resolve(StudentRecordEvent.class),
                        typeResolver.resolve(UserContactEvent.class)
                )
                .tags(
                        new Tag("academic-life.student-record", "Kafka Topic Producer"),
                        new Tag("admission.preenrollment", "Kafka Topic Producer"),
                        new Tag("user.contact", "Kafka Topic Producer"),
                        new Tag("assessment.report", "Kafka Topic Producer"),
                        new Tag("assessment.group.subscription", "Kafka Topic Producer")

                );
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Admission Event Service API")
                .description("Admission event service")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version(appVersion)
                .build();
    }

    @Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                .deepLinking(true)
                .displayOperationId(false)
                .defaultModelsExpandDepth(1)
                .defaultModelExpandDepth(1)
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .displayRequestDuration(false)
                .docExpansion(DocExpansion.NONE)
                .filter(false)
                .maxDisplayedTags(null)
                .operationsSorter(OperationsSorter.ALPHA)
                .showExtensions(false)
                .tagsSorter(TagsSorter.ALPHA)
                .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
                .validatorUrl(null)
                .build();
    }


    private OAuth securitySchema() {
        final List<AuthorizationScope> authorizationScopes = Lists.newArrayList(authorizationScopes());
        final List<GrantType> grantTypes = Lists
                .newArrayList(new ClientCredentialsGrant(baseAuthUrl + "/menu/api/oauth2/token"));
        return new OAuth("oauth2schema", authorizationScopes, grantTypes);
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(securityReferences()).forPaths(PathSelectors.ant("/**"))
                .build();
    }

    private List<SecurityReference> securityReferences() {
        final List<SecurityReference> securityReferences = Lists
                .newArrayList(new SecurityReference("oauth2schema", authorizationScopes()));
        return securityReferences;
    }

    private AuthorizationScope[] authorizationScopes() {
        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[10];
        authorizationScopes[0] = new AuthorizationScope("admission-publish:write", "Write scope");
        authorizationScopes[1] = new AuthorizationScope("admission-publish:read", "read scope");
        authorizationScopes[2] = new AuthorizationScope("contact-publish:write", "Write scope");
        authorizationScopes[3] = new AuthorizationScope("contact-publish:read", "read scope");
        authorizationScopes[4] = new AuthorizationScope("student-record-publish:write", "Write scope");
        authorizationScopes[5] = new AuthorizationScope("student-record-publish:read", "read scope");
        authorizationScopes[6] = new AuthorizationScope("assessment-report-publish:write", "write scope");
        authorizationScopes[7] = new AuthorizationScope("assessment-report-publish:read", "read scope");
        authorizationScopes[8] = new AuthorizationScope("subscript-group-publish:write", "write scope");
        authorizationScopes[9] = new AuthorizationScope("subscript-group-publish:read", "read scope");

        return authorizationScopes;
    }

    @Bean
    public SecurityConfiguration security() {
        return SecurityConfigurationBuilder.builder()
                .realm("admission-event-service-realm")
                .appName("admission-event-service")
                .scopeSeparator(",")
                .additionalQueryStringParams(null)
                .useBasicAuthenticationWithAccessCodeGrant(false)
                .build();
    }
}
