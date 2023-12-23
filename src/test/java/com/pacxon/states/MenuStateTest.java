package com.pacxon.states;
import com.pacxon.controller.Controller;
import com.pacxon.controller.MenuController;
import com.pacxon.model.Menu;
import com.pacxon.viewer.MenuViewer;
import com.pacxon.viewer.Viewer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuStateTest {
    //Verifica se o modelo associado ao Viewer é o mesmo Menu criado anteriormente
    @Test
    void testGetViewer() {
        Menu menu = new Menu();
        MenuState menuState = new MenuState(menu);

        Viewer<Menu> viewer = menuState.getViewer();

        assertNotNull(viewer);
        assertTrue(viewer instanceof MenuViewer);
        assertEquals(menu, viewer.getModel());
    }

    //Verifica se o modelo associado ao Controller é o mesmo Menu criado anteriormente
    @Test
    void testGetController() {
        Menu menu = new Menu();
        MenuState menuState = new MenuState(menu);

        Controller<Menu> controller = menuState.getController();

        assertNotNull(controller);
        assertTrue(controller instanceof MenuController);
        assertEquals(menu, controller.getModel());
    }

}
