package projet.gl51

import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get


@Controller("/student")
class StudentController {

    @Get("/")
    List<Student> index() {
        [
			new Student(firstName: "Déromba", lastName: "Bissari"), 
			new Student(firstName: "Arona", lastName: "Gueye")
		]
    }
}