package com.aor.pacxon.states;
import com.aor.pacxon.controller.Controller;
import com.aor.pacxon.controller.MenuController;
import com.aor.pacxon.model.Menu;
import com.aor.pacxon.viewer.MenuViewer;
import com.aor.pacxon.viewer.Viewer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuStateTest {
    //Verifica se o modelo associado ao Viewer é o mesmo Menu criado anteriormente
    @Test
    void testGetViewer() {
        Menu menu = new Menu(); // Cria uma instância fictícia de Menu
        MenuState menuState = new MenuState(menu);

        Viewer<Menu> viewer = menuState.getViewer();

        assertNotNull(viewer);
        assertTrue(viewer instanceof MenuViewer);
        assertEquals(menu, viewer.getModel());
    }

    //Verifica se o modelo associado ao Controller é o mesmo Menu criado anteriormente
    @Test
    void testGetController() {
        Menu menu = new Menu(); // Cria uma instância fictícia de Menu
        MenuState menuState = new MenuState(menu);

        Controller<Menu> controller = menuState.getController();

        assertNotNull(controller);
        assertTrue(controller instanceof MenuController);
        assertEquals(menu, controller.getModel());
    }

}
