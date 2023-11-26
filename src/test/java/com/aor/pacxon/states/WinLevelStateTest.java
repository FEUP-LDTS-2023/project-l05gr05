package com.aor.pacxon.states;
import com.aor.pacxon.controller.Controller;
import com.aor.pacxon.controller.MenuWinLevelController;
import com.aor.pacxon.model.MenuWinLevel;
import com.aor.pacxon.viewer.MenuWinLevelViewer;
import com.aor.pacxon.viewer.Viewer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class WinLevelStateTest {

    //Este teste verifica se o método getViewer() da classe WinLevelState retorna uma instância correta de Viewer
    @Test
    void testGetViewer() {
        MenuWinLevel menuWinLevel = new MenuWinLevel(100); // Cria uma instância de MenuWinLevel com pontos fictícios
        WinLevelState winLevelState = new WinLevelState(menuWinLevel);

        Viewer<MenuWinLevel> viewer = winLevelState.getViewer();

        assertNotNull(viewer);
        assertTrue(viewer instanceof MenuWinLevelViewer);
        assertEquals(menuWinLevel, viewer.getModel());
    }


    //Este teste verifica se o método getController() da classe WinLevelState retorna uma instância correta de Controller
    @Test
    void testGetController() {
        MenuWinLevel menuWinLevel = new MenuWinLevel(100); // Cria uma instância de MenuWinLevel com pontos fictícios
        WinLevelState winLevelState = new WinLevelState(menuWinLevel);

        Controller<MenuWinLevel> controller = winLevelState.getController();

        assertNotNull(controller);
        assertTrue(controller instanceof MenuWinLevelController);
        assertEquals(menuWinLevel, controller.getModel());
    }

}
