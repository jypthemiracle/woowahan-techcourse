package chess.view;

import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class OutputViewForWeb {
	public static String render(Map<String, Object> model, String templatePath) {
		return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
	}
}
