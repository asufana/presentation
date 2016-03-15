package controllers;

import models.*;
import play.mvc.*;

public class Application extends Controller {
    
    public static void index() {
        final SomeEntity entity = SomeEntity.SAMPLE;
        render(entity);
    }
    
}
