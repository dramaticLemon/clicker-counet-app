#RequestMapping

@GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping
@RequestMapping(path = "/example-path", method = RequestMethod.GET|POST|PUT|DELETE|PATCH)

parameter request mapping
	1. value/path
	@RequestMapping(value = "/users") | @RequestMapping(path = "/users")
	2. HTTP method
	@RequestMapping(value = "/users", method = RequestMethod.GET) 
	3. params
	@RequestMapping(value = "/users", method = RequestMethod.GET, params = "id") // Обрабатывает /users?id=...
	@RequestMapping(value = "/users", method = RequestMethod.GET, params = "!id") // Обрабатывает /users, но не /users?id=...
	4. headers
	@RequestMapping(value = "/users", headers = "content-type=application/json") // Требует заголовок Content-Type: application/json
	5. consumers
	@RequestMapping(value = "/users", consumes = "application/json") // Принимает только JSON
	6. produces
	@RequestMapping(value = "/users", produces = "application/json") // Отвечает в формате JSON


```java
@Controller
@RequestMapping(value = "/vehicles", method = RequestMethod.GET)
class VehicleController {

    @RequestMapping("/home")
    String home() {
        return "home";
    }
}

!  ".../vehicles/home" GET
```

#RequestBody для мапинга нужна стороняя библиоткека jacson

сопоставляет тело HTTP-запроса с объектом  raw json
```java
@PostMapping("/save")
void saveVehicle(@RequestBody Vehicle vehicle) {
    // ...
}
```

#PathVariable 

плохая практика, path variable используетя для уникальных значений user/id
извлекает данные из самого URL-пути
идентификации ресурса.
```java
@RequestMapping(path="/save/{name}/{email}", method=RequestMethod.POST)
	public String saveUserPathVariable(
		@PathVariable("name") String name,
		@PathVariable("email") String email,
		Model model) {
		User user = new User(name, email);
		model.addAttribute("savedUser", user);
		return "success";
	}
```
сделать pathVariable не обязательным
```java
@RequestMapping("/{id}")
Vehicle getVehicle(@PathVariable(required = false) long id) {
    // ...
}
```


#RequestParam

Параметры запроса (после ?)

```java
@RequestMapping("/buy")
Car buyCar(@RequestParam(defaultValue = "5") int seatCount) {
    // ...
}
```



#RequestHeader

используется для получения значений из HTTP-заголовков запроса.
```java
@GetMapping("/getHeader")
public String getHeader(@RequestHeader("User-Agent") String userAgent) {
    return "User-Agent: " + userAgent;
}
@GetMapping("/getHeaderOptional")
public String getHeaderOptional(@RequestHeader(value = "Authorization", required = false) String authorizationHeader) {
    return "Заголовок Authorization: " + (authorizationHeader != null ? authorizationHeader : "не найден");
}
```
#CookieValue

позволяет получить значение конкретного cookie из HTTP-запроса
```java
@GetMapping("/getCookie")
public String getCookie(@CookieValue("myCookie") String cookieValue) {
    return "Значение cookie: " + cookieValue;
}
```
```java
@GetMapping("/getCookieOptional")
public String getCookieOptional(@CookieValue(value = "myCookie", required = false, defaultValue = "default_value") String cookieValue) {
    return "Значение cookie: " + cookieValue;
}
```



@ResponseBody
@RequestMapping("/hello")
String hello() {
    return "Hello World!";
}

@ExceptionHandler(IllegalArgumentException.class)
void onIllegalArgumentException(IllegalArgumentException exception) {
    // ...
}

@ExceptionHandler(IllegalArgumentException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
void onIllegalArgumentException(IllegalArgumentException exception) {
    // ...
}


@Model attribute

like controller method annotation
* вызывается перед каждым методом контроллера, доступен для каждого метода в этом контроллере
@Controller
public class ProductController {

    @ModelAttribute("categories")
    public List<String> populateCategories() {
        return Arrays.asList("Electronics", "Books", "Food");
    }

    @GetMapping("/products")
    public String showProducts() {
        // Здесь модель "categories" уже доступна
        return "products"; // Шаблон products.html имеет доступ к "categories"
    }

    @GetMapping("/product-form")
    public String showProductForm() {
        // И здесь тоже!
        return "product-form"; // Шаблон product-form.html имеет доступ к "categories"
    }
}

#products.html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<body>
    <h1>List category</h1>
    <ul>
        <li th:each="category : ${categories}" th:text="${category}">Category</li>
    </ul>
</body>
</html>
