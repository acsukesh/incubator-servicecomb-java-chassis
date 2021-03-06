package org.apache.servicecomb.demo.springmvc.server;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.ws.rs.core.MediaType;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestSchema(schemaId = "SpringMvcDefaultValues")
@RequestMapping(path = "/springmvc/SpringMvcDefaultValues", produces = MediaType.APPLICATION_JSON)
public class SpringMvcDefaultValues {

  @PostMapping(path = "/form", consumes = MediaType.APPLICATION_FORM_URLENCODED)
  public String form(@RequestParam(name = "a", defaultValue = "20") int a,
      @RequestParam(name = "b", defaultValue = "bobo") String b) {
    return "Hello " + a + b;
  }

  @PostMapping(path = "/header")
  public String header(@RequestHeader(name = "a", defaultValue = "20") int a,
      @RequestHeader(name = "b", defaultValue = "bobo") String b,
      @RequestHeader(name = "c", defaultValue = "30") Integer c) {
    return "Hello " + a + b + c;
  }

  @GetMapping("/query")
  public String query(@RequestParam(name = "a", defaultValue = "20") int a,
      @RequestParam(name = "b", defaultValue = "bobo") String b,
      @RequestParam(name = "c", defaultValue = "40") Integer c, @RequestParam(name = "d") int d) {
    return "Hello " + a + b + c + d;
  }

  @GetMapping("/query2")
  public String query2(@RequestParam("e") int e, @RequestParam(name = "a", defaultValue = "20") int a,
      @RequestParam(name = "b", defaultValue = "bobo") String b,
      @RequestParam(name = "c", defaultValue = "40") Integer c,
      @Min(value = 20) @Max(value = 30) @RequestParam("d") int d) {
    return "Hello " + a + b + c + d + e;
  }

  @GetMapping("/query3")
  public String query3(@RequestParam("a") @Min(value = 20) int a, @RequestParam("b") String b) {
    return "Hello " + a + b;
  }

}
