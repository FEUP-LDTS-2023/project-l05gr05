package com.aor.pacxon.states;
import com.aor.pacxon.controller.Controller;
import com.aor.pacxon.controller.MenuHTPController;
import com.aor.pacxon.model.MenuHTP;
import com.aor.pacxon.viewer.MenuHTPViewer;
import com.aor.pacxon.viewer.Viewer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HTPStateTest {
    //Verifica se o modelo associado ao Viewer é o mesmo MenuHTP criado anteriormente
    @Test
    void testGetViewer() {
        MenuHTP menuHTP = new MenuHTP(); // Crie uma instância fictícia de MenuHTP
        HTPState htpState = new HTPState(menuHTP);

        Viewer<MenuHTP> viewer = htpState.getViewer();

        assertNotNull(viewer);
        assertTrue(viewer instanceof MenuHTPViewer);
        assertEquals(menuHTP, viewer.getModel());
    }


    //Verifica se o modelo associado ao Controller é o mesmo MenuHTP criado anteriormente
    @Test
    void testGetController() {
        MenuHTP menuHTP = new MenuHTP(); // Cria uma instância fictícia de MenuHTP
        HTPState htpState = new HTPState(menuHTP);

        Controller<MenuHTP> controller = htpState.getController();

        assertNotNull(controller);
        assertTrue(controller instanceof MenuHTPController);
        assertEquals(menuHTP, controller.getModel());
    }

}
