package com.aor.pacxon.states;
import com.aor.pacxon.controller.Controller;
import com.aor.pacxon.controller.MenuControlsController;
import com.aor.pacxon.model.MenuControls;
import com.aor.pacxon.viewer.MenuControlsViewer;
import com.aor.pacxon.viewer.Viewer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ControlsStateTest {

    //Verifica se o modelo associado ao Viewer é o mesmo MenuControls criado anteriormente
    @Test
    void testGetViewer() {
        MenuControls menuControls = new MenuControls(); // Crie uma instância de MenuControls
        ControlsState controlsState = new ControlsState(menuControls);

        Viewer<MenuControls> viewer = controlsState.getViewer();

        assertNotNull(viewer);
        assertTrue(viewer instanceof MenuControlsViewer);
        assertEquals(menuControls, viewer.getModel());
    }

    //Verifica se o modelo associado ao Controller é o mesmo MenuControls criado anteriormente
    @Test
    void testGetController() {
        MenuControls menuControls = new MenuControls(); // Crie uma instância de MenuControls
        ControlsState controlsState = new ControlsState(menuControls);

        Controller<MenuControls> controller = controlsState.getController();

        assertNotNull(controller);
        assertTrue(controller instanceof MenuControlsController);
        assertEquals(menuControls, controller.getModel());
    }

}