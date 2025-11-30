
```text
    @Component Annotation 
    @Autowired Annotation
    @Qualifier Annotation
    @Primary Annotation
    @SpringBootApplication
    @Bean
    @Configuration Annotations
    @Controller, @Service and @Repository
    @Lazy Annotation
    @Scope Annotation
    @Value Annotation
    @PropertySource and PropertySources Annotations
    @ConfigurationProperties Annotation
    @Controller and @ResponseBody Annotations
    @RestController Annotation
    @RequestMapping Annotation
    @GetMapping Annotation
    @PostMapping and @RequestBody Annotations
    @PutMapping Annotation
    @DeleteMapping Annotation
    @PathVariable Annotation
    @RequestParam Annotation
    @EnableAutoConfiguration
    @ComponentScan
```

#### *@Component* Annotation
We have used the `@Component` annotation in the `App` Class file. And we could observe the ``Hello World! from Constructor`` written in the constructor of the `App` class.

![Console-Output-Console](Console-Output-Console.png)

#### *@Autowired* Annotation
We have used @Autowire annotation in the `AutowireAnnotationController` class for Greet Interface.And for the creation of greet Bean, we have used `@Service` Annotation 
instead of `@Component` Annotation. `@Service` does the same work as `@Component` but also makes writing service-layer classes to make your codebase more expressive and self-documenting.
![Autowire](Web-Output-Autowire.png)
