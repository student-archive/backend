package ru.giv.star.backend.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;

@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2022-03-17T11:30:21.915317900+03:00[Europe/Moscow]")
@Controller
@RequestMapping("${openapi.Star API.base-path:}")
public class ContentApiController implements ContentApi {

  private final NativeWebRequest request;

  @org.springframework.beans.factory.annotation.Autowired
  public ContentApiController(NativeWebRequest request) {
    this.request = request;
  }

  @Override
  public Optional<NativeWebRequest> getRequest() {
    return Optional.ofNullable(request);
  }
}
