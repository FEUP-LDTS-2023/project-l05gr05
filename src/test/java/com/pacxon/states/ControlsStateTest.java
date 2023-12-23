package com.pacxon.states;
import com.pacxon.controller.Controller;
import com.pacxon.controller.MenuControlsController;
import com.pacxon.model.MenuControls;
import com.pacxon.viewer.MenuControlsViewer;
import com.pacxon.viewer.Viewer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ControlsStateTest {

    //Verifica se o modelo associado ao Viewer é o mesmo MenuControls criado anteriormente
    @Test
    void testGetViewer() {
        MenuControls menuControls = new MenuControls();
        ControlsState controlsState = new ControlsState(menuControls);

        Viewer<MenuControls> viewer = controlsState.getViewer();

        assertNotNull(viewer);
        assertTrue(viewer instanceof MenuControlsViewer);
        assertEquals(menuControls, viewer.getModel());
    }

    //Verifica se o modelo associado ao Controller é o mesmo MenuControls criado anteriormente
    @Test
    void testGetController() {
        MenuControls menuControls = new MenuControls();
        ControlsState controlsState = new ControlsState(menuControls);

        Controller<MenuControls> controller = controlsState.getController();

        assertNotNull(controller);
        assertTrue(controller instanceof MenuControlsController);
        assertEquals(menuControls, controller.getModel());
    }

}