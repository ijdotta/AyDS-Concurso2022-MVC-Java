package controller;

import model.ModelInjector;
import view.ViewInjector;

public class ControllerInjector {
    private static ControllerInjector instance;

    public static ControllerInjector getInstance() {
        if (instance == null) {
            instance = new ControllerInjector();
        }
        return instance;
    }

    public void init() {
        new ControllerImpl(
                ViewInjector.getInstance().getView(),
                ModelInjector.getInstance().getModel()
        );
    }
}
