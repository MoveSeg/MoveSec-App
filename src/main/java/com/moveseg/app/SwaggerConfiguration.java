package com.moveseg.app;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;

@Configuration
// @Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("MoveSec API")
                        .description("Spring shop sample application")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }

    @Bean
    public GroupedOpenApi authenticatedApi() {
        return GroupedOpenApi.builder()
                .group("Authenticated API")
                .pathsToMatch("/api/**")
                .addOpenApiCustomizer(
                        openApi -> openApi.addSecurityItem(new SecurityRequirement().addList("bearerAuth")))
                .build();
    }

    // @Bean
    // Docket api() {

    // Docket docket = new Docket(DocumentationType.SWAGGER_2)
    // .useDefaultResponseMessages(false)
    // .forCodeGeneration(true)
    // .select()
    // .apis(RequestHandlerSelectors.any())
    // .paths(PathSelectors.regex("/api/.*"))
    // .build();

    // return registerModelSubstitutes(docket)
    // .apiInfo(apiInfo());
    // }

    // ApiInfo apiInfo() {
    // return new ApiInfoBuilder()
    // .title("Domain REST API :: Borrower")
    // .description("Domain REST Interface for Borrower Service.")
    // .build();
    // }

    // public void addResourceHandlers(ResourceHandlerRegistry registry) {
    // registry.addResourceHandler("swagger-ui.html")
    // .addResourceLocations("classpath:/META-INF/resources/");

    // registry.addResourceHandler("/webjars/**")
    // .addResourceLocations("classpath:/META-INF/resources/webjars/");
    // }

    // Docket registerModelSubstitutes(Docket docket) {

    // // docket.directModelSubstitute(AccountId.class, String.class);
    // // docket.directModelSubstitute(BusinessId.class, String.class);

    // // docket.directModelSubstitute(Money.class,
    // // MonetaryAmountApiRepresentation.class);
    // // docket.directModelSubstitute(FastMoney.class,
    // // MonetaryAmountApiRepresentation.class);
    // // docket.directModelSubstitute(RoundedMoney.class,
    // // MonetaryAmountApiRepresentation.class);
    // // docket.directModelSubstitute(MonetaryAmount.class,
    // // MonetaryAmountApiRepresentation.class);

    // return docket;
    // }

    // @ApiModel("MonetaryAmount")
    // interface MonetaryAmountApiRepresentation {

    // @JsonProperty
    // @ApiModelProperty(name = AMOUNT_FIELD_NAME, required = true)
    // BigDecimal value();

    // @JsonProperty
    // @ApiModelProperty(name = CURRENCY_FIELD_NAME, required = true,
    // allowableValues = "BRL")
    // String currency();

    // }
}
