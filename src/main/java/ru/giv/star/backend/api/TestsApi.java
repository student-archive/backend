/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.0.0).
 * https://openapi-generator.tech Do not edit the class manually.
 */
package ru.giv.star.backend.api;

import ru.giv.star.backend.models.Error;
import ru.giv.star.backend.models.Question;
import ru.giv.star.backend.models.Quiz;
import ru.giv.star.backend.models.UNKNOWN_BASE_TYPE;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2022-03-17T11:30:21.915317900+03:00[Europe/Moscow]")
@Validated
@Api(value = "Tests", description = "the Tests API")
public interface TestsApi {

  default Optional<NativeWebRequest> getRequest() {
    return Optional.empty();
  }

  /**
   * DELETE /quiz/{id} : Delete quiz Delete quiz Access level: Captains+
   *
   * @param id id of quiz (required)
   * @return OK (status code 200) or Unauthorized (status code 401) or Forbidden (status code 403)
   *     or Not Found (status code 404)
   */
  @ApiOperation(
      value = "Delete quiz",
      nickname = "deleteQuizId",
      notes = "Delete quiz Access level: Captains+",
      authorizations = {@Authorization(value = "Authorization")},
      tags = {
        "tests",
      })
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class)
      })
  @DeleteMapping(
      value = "/quiz/{id}",
      produces = {"application/json"})
  default ResponseEntity<Void> deleteQuizId(
      @ApiParam(value = "id of quiz", required = true) @PathVariable("id") String id) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  /**
   * DELETE /question/{id} : Delete question Delete question permanently Access level: Captains+
   *
   * @param id id of question (required)
   * @return OK (status code 200) or Unauthorized (status code 401) or Forbidden (status code 403)
   *     or Not Found (status code 404)
   */
  @ApiOperation(
      value = "Delete question",
      nickname = "deleteQuizQuizIdQuestionQuestionId",
      notes = "Delete question permanently Access level: Captains+",
      authorizations = {@Authorization(value = "Authorization")},
      tags = {
        "tests",
      })
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class)
      })
  @DeleteMapping(
      value = "/question/{id}",
      produces = {"application/json"})
  default ResponseEntity<Void> deleteQuizQuizIdQuestionQuestionId(
      @ApiParam(value = "id of question", required = true) @PathVariable("id") String id) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  /**
   * GET /quiz/{id} : Get exact quiz Get exact quiz Access level: Any user
   *
   * @param id id of quiz (required)
   * @return OK (status code 200) or Unauthorized (status code 401) or Forbidden (status code 403)
   *     or Not Found (status code 404)
   */
  @ApiOperation(
      value = "Get exact quiz",
      nickname = "getQuizId",
      notes = "Get exact quiz Access level: Any user",
      response = Quiz.class,
      authorizations = {@Authorization(value = "Authorization")},
      tags = {
        "tests",
      })
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "OK", response = Quiz.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class)
      })
  @GetMapping(
      value = "/quiz/{id}",
      produces = {"application/json"})
  default ResponseEntity<Quiz> getQuizId(
      @ApiParam(value = "id of quiz", required = true) @PathVariable("id") String id) {
    getRequest()
        .ifPresent(
            request -> {
              for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                  String exampleString =
                      "{ \"subject\" : { \"tutors\" : [ { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"phone\" : \"phone\", \"subjects\" : [ null, null ], \"link\" : \"link\", \"id\" : \"8fae1554-9e9c-4ea3-8104-35ad1d97a05c\", \"patronym\" : \"patronym\", \"email\" : \"email\" }, { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"phone\" : \"phone\", \"subjects\" : [ null, null ], \"link\" : \"link\", \"id\" : \"8fae1554-9e9c-4ea3-8104-35ad1d97a05c\", \"patronym\" : \"patronym\", \"email\" : \"email\" } ], \"semester\" : 3, \"id\" : \"0b5f18cd-3907-4fd1-b64f-bd5d44fc5f66\", \"subjectName\" : \"subjectName\", \"group\" : { \"speciality\" : { \"specialityName\" : \"specialityName\", \"id\" : \"f2dd849d-0daa-4a05-89df-078946aaade9\" }, \"students\" : [ { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"role\" : { \"roleName\" : \"roleName\", \"id\" : \"edfc5608-30b2-4408-bd87-5d0fa260bc4b\", \"roleDescription\" : \"roleDescription\" }, \"id\" : \"id\", \"account\" : { \"id\" : \"99167df3-123e-4d1b-9542-3950c7eeef28\", \"lastLoginDate\" : 1647159287, \"passwordHash\" : \"passwordHash\", \"username\" : \"ejik\" } }, { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"role\" : { \"roleName\" : \"roleName\", \"id\" : \"edfc5608-30b2-4408-bd87-5d0fa260bc4b\", \"roleDescription\" : \"roleDescription\" }, \"id\" : \"id\", \"account\" : { \"id\" : \"99167df3-123e-4d1b-9542-3950c7eeef28\", \"lastLoginDate\" : 1647159287, \"passwordHash\" : \"passwordHash\", \"username\" : \"ejik\" } } ], \"id\" : \"b3120bb1-02f4-4260-b93f-ceca1fdd286d\", \"groupNumber\" : \"groupNumber\" } }, \"questions\" : [ { \"questionDescription\" : \"questionDescription\", \"id\" : \"a8f63983-99a9-4c2d-a5fd-3fd7d4839ba9\", \"variants\" : [ { \"id\" : \"e13764a2-938a-4bfe-98e4-d6b0de0006ec\", \"quizVariantText\" : \"quizVariantText\", \"isCorrect\" : true }, { \"id\" : \"e13764a2-938a-4bfe-98e4-d6b0de0006ec\", \"quizVariantText\" : \"quizVariantText\", \"isCorrect\" : true } ], \"questionText\" : \"questionText\" }, { \"questionDescription\" : \"questionDescription\", \"id\" : \"a8f63983-99a9-4c2d-a5fd-3fd7d4839ba9\", \"variants\" : [ { \"id\" : \"e13764a2-938a-4bfe-98e4-d6b0de0006ec\", \"quizVariantText\" : \"quizVariantText\", \"isCorrect\" : true }, { \"id\" : \"e13764a2-938a-4bfe-98e4-d6b0de0006ec\", \"quizVariantText\" : \"quizVariantText\", \"isCorrect\" : true } ], \"questionText\" : \"questionText\" } ], \"id\" : \"e373ac57-9896-4b61-b768-91c7c17cc6cd\" }";
                  ApiUtil.setExampleResponse(request, "application/json", exampleString);
                  break;
                }
              }
            });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  /**
   * GET /quiz/{id}/questions : Get a list of questions in the quiz Get a list of questions in the
   * quiz Access level: Editors+
   *
   * @param id Quiz ID (required)
   * @return OK (status code 200) or Unauthorized (status code 401) or Forbidden (status code 403)
   *     or Not Found (status code 404)
   */
  @ApiOperation(
      value = "Get a list of questions in the quiz",
      nickname = "getQuizIdQuestions",
      notes = "Get a list of questions in the quiz Access level: Editors+",
      response = Question.class,
      responseContainer = "List",
      authorizations = {@Authorization(value = "Authorization")},
      tags = {
        "tests",
      })
  @ApiResponses(
      value = {
        @ApiResponse(
            code = 200,
            message = "OK",
            response = Question.class,
            responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class)
      })
  @GetMapping(
      value = "/quiz/{id}/questions",
      produces = {"application/json"})
  default ResponseEntity<List<Question>> getQuizIdQuestions(
      @ApiParam(value = "Quiz ID", required = true) @PathVariable("id") String id) {
    getRequest()
        .ifPresent(
            request -> {
              for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                  String exampleString =
                      "{ \"questionDescription\" : \"questionDescription\", \"id\" : \"a8f63983-99a9-4c2d-a5fd-3fd7d4839ba9\", \"variants\" : [ { \"id\" : \"e13764a2-938a-4bfe-98e4-d6b0de0006ec\", \"quizVariantText\" : \"quizVariantText\", \"isCorrect\" : true }, { \"id\" : \"e13764a2-938a-4bfe-98e4-d6b0de0006ec\", \"quizVariantText\" : \"quizVariantText\", \"isCorrect\" : true } ], \"questionText\" : \"questionText\" }";
                  ApiUtil.setExampleResponse(request, "application/json", exampleString);
                  break;
                }
              }
            });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  /**
   * GET /question/{id} : Get exact question Get exact question Access level: Any user
   *
   * @param id id of question (required)
   * @return OK (status code 200) or Unauthorized (status code 401) or Forbidden (status code 403)
   *     or Not Found (status code 404)
   */
  @ApiOperation(
      value = "Get exact question",
      nickname = "getQuizQuizIdQuestionQuestionId",
      notes = "Get exact question Access level: Any user",
      response = Question.class,
      authorizations = {@Authorization(value = "Authorization")},
      tags = {
        "tests",
      })
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "OK", response = Question.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class)
      })
  @GetMapping(
      value = "/question/{id}",
      produces = {"application/json"})
  default ResponseEntity<Question> getQuizQuizIdQuestionQuestionId(
      @ApiParam(value = "id of question", required = true) @PathVariable("id") String id) {
    getRequest()
        .ifPresent(
            request -> {
              for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                  String exampleString =
                      "{ \"questionDescription\" : \"questionDescription\", \"id\" : \"a8f63983-99a9-4c2d-a5fd-3fd7d4839ba9\", \"variants\" : [ { \"id\" : \"e13764a2-938a-4bfe-98e4-d6b0de0006ec\", \"quizVariantText\" : \"quizVariantText\", \"isCorrect\" : true }, { \"id\" : \"e13764a2-938a-4bfe-98e4-d6b0de0006ec\", \"quizVariantText\" : \"quizVariantText\", \"isCorrect\" : true } ], \"questionText\" : \"questionText\" }";
                  ApiUtil.setExampleResponse(request, "application/json", exampleString);
                  break;
                }
              }
            });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  /**
   * GET /quizzes/{groupId} : Get list of quizzes Gets list of created quizzes in exact group Access
   * level: Any user
   *
   * @param groupId ID of group (required)
   * @return OK (status code 200) or Unauthorized (status code 401) or Forbidden (status code 403)
   *     or Not Found (status code 404)
   */
  @ApiOperation(
      value = "Get list of quizzes",
      nickname = "getQuizzes",
      notes = "Gets list of created quizzes in exact group Access level: Any user",
      response = Quiz.class,
      responseContainer = "List",
      authorizations = {@Authorization(value = "Authorization")},
      tags = {
        "tests",
      })
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "OK", response = Quiz.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class)
      })
  @GetMapping(
      value = "/quizzes/{groupId}",
      produces = {"application/json"})
  default ResponseEntity<List<Quiz>> getQuizzes(
      @ApiParam(value = "ID of group", required = true) @PathVariable("groupId") String groupId) {
    getRequest()
        .ifPresent(
            request -> {
              for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                  String exampleString =
                      "{ \"subject\" : { \"tutors\" : [ { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"phone\" : \"phone\", \"subjects\" : [ null, null ], \"link\" : \"link\", \"id\" : \"8fae1554-9e9c-4ea3-8104-35ad1d97a05c\", \"patronym\" : \"patronym\", \"email\" : \"email\" }, { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"phone\" : \"phone\", \"subjects\" : [ null, null ], \"link\" : \"link\", \"id\" : \"8fae1554-9e9c-4ea3-8104-35ad1d97a05c\", \"patronym\" : \"patronym\", \"email\" : \"email\" } ], \"semester\" : 3, \"id\" : \"0b5f18cd-3907-4fd1-b64f-bd5d44fc5f66\", \"subjectName\" : \"subjectName\", \"group\" : { \"speciality\" : { \"specialityName\" : \"specialityName\", \"id\" : \"f2dd849d-0daa-4a05-89df-078946aaade9\" }, \"students\" : [ { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"role\" : { \"roleName\" : \"roleName\", \"id\" : \"edfc5608-30b2-4408-bd87-5d0fa260bc4b\", \"roleDescription\" : \"roleDescription\" }, \"id\" : \"id\", \"account\" : { \"id\" : \"99167df3-123e-4d1b-9542-3950c7eeef28\", \"lastLoginDate\" : 1647159287, \"passwordHash\" : \"passwordHash\", \"username\" : \"ejik\" } }, { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"role\" : { \"roleName\" : \"roleName\", \"id\" : \"edfc5608-30b2-4408-bd87-5d0fa260bc4b\", \"roleDescription\" : \"roleDescription\" }, \"id\" : \"id\", \"account\" : { \"id\" : \"99167df3-123e-4d1b-9542-3950c7eeef28\", \"lastLoginDate\" : 1647159287, \"passwordHash\" : \"passwordHash\", \"username\" : \"ejik\" } } ], \"id\" : \"b3120bb1-02f4-4260-b93f-ceca1fdd286d\", \"groupNumber\" : \"groupNumber\" } }, \"questions\" : [ { \"questionDescription\" : \"questionDescription\", \"id\" : \"a8f63983-99a9-4c2d-a5fd-3fd7d4839ba9\", \"variants\" : [ { \"id\" : \"e13764a2-938a-4bfe-98e4-d6b0de0006ec\", \"quizVariantText\" : \"quizVariantText\", \"isCorrect\" : true }, { \"id\" : \"e13764a2-938a-4bfe-98e4-d6b0de0006ec\", \"quizVariantText\" : \"quizVariantText\", \"isCorrect\" : true } ], \"questionText\" : \"questionText\" }, { \"questionDescription\" : \"questionDescription\", \"id\" : \"a8f63983-99a9-4c2d-a5fd-3fd7d4839ba9\", \"variants\" : [ { \"id\" : \"e13764a2-938a-4bfe-98e4-d6b0de0006ec\", \"quizVariantText\" : \"quizVariantText\", \"isCorrect\" : true }, { \"id\" : \"e13764a2-938a-4bfe-98e4-d6b0de0006ec\", \"quizVariantText\" : \"quizVariantText\", \"isCorrect\" : true } ], \"questionText\" : \"questionText\" } ], \"id\" : \"e373ac57-9896-4b61-b768-91c7c17cc6cd\" }";
                  ApiUtil.setExampleResponse(request, "application/json", exampleString);
                  break;
                }
              }
            });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  /**
   * PATCH /quiz/{id} : Update quiz Update quiz Access level: Captains+
   *
   * @param id id of quiz (required)
   * @param UNKNOWN_BASE_TYPE (optional)
   * @return OK (status code 200) or Bad Request (status code 400) or Unauthorized (status code 401)
   *     or Forbidden (status code 403) or Not Found (status code 404)
   */
  @ApiOperation(
      value = "Update quiz",
      nickname = "patchQuizId",
      notes = "Update quiz Access level: Captains+",
      response = Quiz.class,
      authorizations = {@Authorization(value = "Authorization")},
      tags = {
        "tests",
      })
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "OK", response = Quiz.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class)
      })
  @PatchMapping(
      value = "/quiz/{id}",
      produces = {"application/json"},
      consumes = {"application/json"})
  default ResponseEntity<Quiz> patchQuizId(
      @ApiParam(value = "id of quiz", required = true) @PathVariable("id") String id,
      @ApiParam(value = "") @Valid @RequestBody(required = false)
          UNKNOWN_BASE_TYPE UNKNOWN_BASE_TYPE) {
    getRequest()
        .ifPresent(
            request -> {
              for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                  String exampleString =
                      "{ \"subject\" : { \"tutors\" : [ { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"phone\" : \"phone\", \"subjects\" : [ null, null ], \"link\" : \"link\", \"id\" : \"8fae1554-9e9c-4ea3-8104-35ad1d97a05c\", \"patronym\" : \"patronym\", \"email\" : \"email\" }, { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"phone\" : \"phone\", \"subjects\" : [ null, null ], \"link\" : \"link\", \"id\" : \"8fae1554-9e9c-4ea3-8104-35ad1d97a05c\", \"patronym\" : \"patronym\", \"email\" : \"email\" } ], \"semester\" : 3, \"id\" : \"0b5f18cd-3907-4fd1-b64f-bd5d44fc5f66\", \"subjectName\" : \"subjectName\", \"group\" : { \"speciality\" : { \"specialityName\" : \"specialityName\", \"id\" : \"f2dd849d-0daa-4a05-89df-078946aaade9\" }, \"students\" : [ { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"role\" : { \"roleName\" : \"roleName\", \"id\" : \"edfc5608-30b2-4408-bd87-5d0fa260bc4b\", \"roleDescription\" : \"roleDescription\" }, \"id\" : \"id\", \"account\" : { \"id\" : \"99167df3-123e-4d1b-9542-3950c7eeef28\", \"lastLoginDate\" : 1647159287, \"passwordHash\" : \"passwordHash\", \"username\" : \"ejik\" } }, { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"role\" : { \"roleName\" : \"roleName\", \"id\" : \"edfc5608-30b2-4408-bd87-5d0fa260bc4b\", \"roleDescription\" : \"roleDescription\" }, \"id\" : \"id\", \"account\" : { \"id\" : \"99167df3-123e-4d1b-9542-3950c7eeef28\", \"lastLoginDate\" : 1647159287, \"passwordHash\" : \"passwordHash\", \"username\" : \"ejik\" } } ], \"id\" : \"b3120bb1-02f4-4260-b93f-ceca1fdd286d\", \"groupNumber\" : \"groupNumber\" } }, \"questions\" : [ { \"questionDescription\" : \"questionDescription\", \"id\" : \"a8f63983-99a9-4c2d-a5fd-3fd7d4839ba9\", \"variants\" : [ { \"id\" : \"e13764a2-938a-4bfe-98e4-d6b0de0006ec\", \"quizVariantText\" : \"quizVariantText\", \"isCorrect\" : true }, { \"id\" : \"e13764a2-938a-4bfe-98e4-d6b0de0006ec\", \"quizVariantText\" : \"quizVariantText\", \"isCorrect\" : true } ], \"questionText\" : \"questionText\" }, { \"questionDescription\" : \"questionDescription\", \"id\" : \"a8f63983-99a9-4c2d-a5fd-3fd7d4839ba9\", \"variants\" : [ { \"id\" : \"e13764a2-938a-4bfe-98e4-d6b0de0006ec\", \"quizVariantText\" : \"quizVariantText\", \"isCorrect\" : true }, { \"id\" : \"e13764a2-938a-4bfe-98e4-d6b0de0006ec\", \"quizVariantText\" : \"quizVariantText\", \"isCorrect\" : true } ], \"questionText\" : \"questionText\" } ], \"id\" : \"e373ac57-9896-4b61-b768-91c7c17cc6cd\" }";
                  ApiUtil.setExampleResponse(request, "application/json", exampleString);
                  break;
                }
              }
            });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  /**
   * PATCH /question/{id} : Change question Change question Access level: Captains only
   *
   * @param id id of question (required)
   * @param UNKNOWN_BASE_TYPE (optional)
   * @return OK (status code 200) or Unauthorized (status code 401) or Forbidden (status code 403)
   *     or Not Found (status code 404)
   */
  @ApiOperation(
      value = "Change question",
      nickname = "patchQuizQuizIdQuestionQuestionId",
      notes = "Change question Access level: Captains only",
      response = Question.class,
      authorizations = {@Authorization(value = "Authorization")},
      tags = {
        "tests",
      })
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "OK", response = Question.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class)
      })
  @PatchMapping(
      value = "/question/{id}",
      produces = {"application/json"},
      consumes = {"application/json"})
  default ResponseEntity<Question> patchQuizQuizIdQuestionQuestionId(
      @ApiParam(value = "id of question", required = true) @PathVariable("id") String id,
      @ApiParam(value = "") @Valid @RequestBody(required = false)
          UNKNOWN_BASE_TYPE UNKNOWN_BASE_TYPE) {
    getRequest()
        .ifPresent(
            request -> {
              for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                  String exampleString =
                      "{ \"questionDescription\" : \"questionDescription\", \"id\" : \"a8f63983-99a9-4c2d-a5fd-3fd7d4839ba9\", \"variants\" : [ { \"id\" : \"e13764a2-938a-4bfe-98e4-d6b0de0006ec\", \"quizVariantText\" : \"quizVariantText\", \"isCorrect\" : true }, { \"id\" : \"e13764a2-938a-4bfe-98e4-d6b0de0006ec\", \"quizVariantText\" : \"quizVariantText\", \"isCorrect\" : true } ], \"questionText\" : \"questionText\" }";
                  ApiUtil.setExampleResponse(request, "application/json", exampleString);
                  break;
                }
              }
            });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  /**
   * POST /quiz/{id}/questions : Create new question Create new question Access level: Captains+
   *
   * @param id Quiz ID (required)
   * @param UNKNOWN_BASE_TYPE (optional)
   * @return OK (status code 200) or Unauthorized (status code 401) or Forbidden (status code 403)
   *     or Not Found (status code 404)
   */
  @ApiOperation(
      value = "Create new question",
      nickname = "postQuizIdQuestions",
      notes = "Create new question Access level: Captains+",
      response = Question.class,
      authorizations = {@Authorization(value = "Authorization")},
      tags = {
        "tests",
      })
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "OK", response = Question.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class)
      })
  @PostMapping(
      value = "/quiz/{id}/questions",
      produces = {"application/json"},
      consumes = {"application/json"})
  default ResponseEntity<Question> postQuizIdQuestions(
      @ApiParam(value = "Quiz ID", required = true) @PathVariable("id") String id,
      @ApiParam(value = "") @Valid @RequestBody(required = false)
          UNKNOWN_BASE_TYPE UNKNOWN_BASE_TYPE) {
    getRequest()
        .ifPresent(
            request -> {
              for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                  String exampleString =
                      "{ \"questionDescription\" : \"questionDescription\", \"id\" : \"a8f63983-99a9-4c2d-a5fd-3fd7d4839ba9\", \"variants\" : [ { \"id\" : \"e13764a2-938a-4bfe-98e4-d6b0de0006ec\", \"quizVariantText\" : \"quizVariantText\", \"isCorrect\" : true }, { \"id\" : \"e13764a2-938a-4bfe-98e4-d6b0de0006ec\", \"quizVariantText\" : \"quizVariantText\", \"isCorrect\" : true } ], \"questionText\" : \"questionText\" }";
                  ApiUtil.setExampleResponse(request, "application/json", exampleString);
                  break;
                }
              }
            });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  /**
   * POST /quizzes/{groupId} : Create new quiz Creates new quiz for the exact group Access level:
   * Captains+
   *
   * @param groupId ID of group (required)
   * @param UNKNOWN_BASE_TYPE (optional)
   * @return OK (status code 200) or Bad Request (status code 400) or Unauthorized (status code 401)
   *     or Forbidden (status code 403) or Not Found (status code 404)
   */
  @ApiOperation(
      value = "Create new quiz",
      nickname = "postQuizzes",
      notes = "Creates new quiz for the exact group Access level: Captains+",
      response = Quiz.class,
      authorizations = {@Authorization(value = "Authorization")},
      tags = {
        "tests",
      })
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "OK", response = Quiz.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class)
      })
  @PostMapping(
      value = "/quizzes/{groupId}",
      produces = {"application/json"},
      consumes = {"application/json"})
  default ResponseEntity<Quiz> postQuizzes(
      @ApiParam(value = "ID of group", required = true) @PathVariable("groupId") String groupId,
      @ApiParam(value = "") @Valid @RequestBody(required = false)
          UNKNOWN_BASE_TYPE UNKNOWN_BASE_TYPE) {
    getRequest()
        .ifPresent(
            request -> {
              for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                  String exampleString =
                      "{ \"subject\" : { \"tutors\" : [ { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"phone\" : \"phone\", \"subjects\" : [ null, null ], \"link\" : \"link\", \"id\" : \"8fae1554-9e9c-4ea3-8104-35ad1d97a05c\", \"patronym\" : \"patronym\", \"email\" : \"email\" }, { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"phone\" : \"phone\", \"subjects\" : [ null, null ], \"link\" : \"link\", \"id\" : \"8fae1554-9e9c-4ea3-8104-35ad1d97a05c\", \"patronym\" : \"patronym\", \"email\" : \"email\" } ], \"semester\" : 3, \"id\" : \"0b5f18cd-3907-4fd1-b64f-bd5d44fc5f66\", \"subjectName\" : \"subjectName\", \"group\" : { \"speciality\" : { \"specialityName\" : \"specialityName\", \"id\" : \"f2dd849d-0daa-4a05-89df-078946aaade9\" }, \"students\" : [ { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"role\" : { \"roleName\" : \"roleName\", \"id\" : \"edfc5608-30b2-4408-bd87-5d0fa260bc4b\", \"roleDescription\" : \"roleDescription\" }, \"id\" : \"id\", \"account\" : { \"id\" : \"99167df3-123e-4d1b-9542-3950c7eeef28\", \"lastLoginDate\" : 1647159287, \"passwordHash\" : \"passwordHash\", \"username\" : \"ejik\" } }, { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"role\" : { \"roleName\" : \"roleName\", \"id\" : \"edfc5608-30b2-4408-bd87-5d0fa260bc4b\", \"roleDescription\" : \"roleDescription\" }, \"id\" : \"id\", \"account\" : { \"id\" : \"99167df3-123e-4d1b-9542-3950c7eeef28\", \"lastLoginDate\" : 1647159287, \"passwordHash\" : \"passwordHash\", \"username\" : \"ejik\" } } ], \"id\" : \"b3120bb1-02f4-4260-b93f-ceca1fdd286d\", \"groupNumber\" : \"groupNumber\" } }, \"questions\" : [ { \"questionDescription\" : \"questionDescription\", \"id\" : \"a8f63983-99a9-4c2d-a5fd-3fd7d4839ba9\", \"variants\" : [ { \"id\" : \"e13764a2-938a-4bfe-98e4-d6b0de0006ec\", \"quizVariantText\" : \"quizVariantText\", \"isCorrect\" : true }, { \"id\" : \"e13764a2-938a-4bfe-98e4-d6b0de0006ec\", \"quizVariantText\" : \"quizVariantText\", \"isCorrect\" : true } ], \"questionText\" : \"questionText\" }, { \"questionDescription\" : \"questionDescription\", \"id\" : \"a8f63983-99a9-4c2d-a5fd-3fd7d4839ba9\", \"variants\" : [ { \"id\" : \"e13764a2-938a-4bfe-98e4-d6b0de0006ec\", \"quizVariantText\" : \"quizVariantText\", \"isCorrect\" : true }, { \"id\" : \"e13764a2-938a-4bfe-98e4-d6b0de0006ec\", \"quizVariantText\" : \"quizVariantText\", \"isCorrect\" : true } ], \"questionText\" : \"questionText\" } ], \"id\" : \"e373ac57-9896-4b61-b768-91c7c17cc6cd\" }";
                  ApiUtil.setExampleResponse(request, "application/json", exampleString);
                  break;
                }
              }
            });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }
}
