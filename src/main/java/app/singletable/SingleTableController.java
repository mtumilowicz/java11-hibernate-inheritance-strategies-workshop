package app.singletable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("single-table")
public class SingleTableController {
	
	@Autowired
	CircleRepository circleRepository;
	
	@Autowired
	RectangleRepository rectangleRepository;

	@Autowired
	ShapeRepository shapeRepository;
	
	@GetMapping
	public Object get() {
		List<? super Shape> shapes = new LinkedList<>();
		shapes.addAll(circleRepository.findAll());
		shapes.addAll(rectangleRepository.findAll());

		return shapes;
//		return shapeRepository.findAll();
	}
}