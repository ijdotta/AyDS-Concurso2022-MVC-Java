package main;

import controller.ControllerInjector;
import view.ViewInjector;

public class Main {

    public static void main(String[] args) {
        initGraph();
        ViewInjector.getInstance().getView().openView();
    }

    private static void initGraph() {
        ControllerInjector.getInstance().init();
    }

}
