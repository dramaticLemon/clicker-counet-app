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


@Controller
@RequestMapping(value = "/vehicles", method = RequestMethod.GET)
class VehicleController {

    @RequestMapping("/home")
    String home() {
        return "home";
    }
}

!  ".../vehicles/home" GET


#RequestBody

сопоставляет тело HTTP-запроса с объектом  raw json
@PostMapping("/save")
void saveVehicle(@RequestBody Vehicle vehicle) {
    // ...
}
