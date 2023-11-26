package com.aor.pacxon.states;
import com.aor.pacxon.controller.Controller;
import com.aor.pacxon.controller.MenuWinGameController;
import com.aor.pacxon.model.MenuWinGame;
import com.aor.pacxon.viewer.MenuWinGameViewer;
import com.aor.pacxon.viewer.Viewer;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class WinGameStateTest {
    //Verifica se o método getViewer() retorna uma instância correta de MenuWinGameViewer. Isso é importante para garantir que o objeto correto
    // seja utilizado para exibir o modelo específico do menu de vitória do jogo
    @Test
    void testGetViewer() {
        MenuWinGame model = mock(MenuWinGame.class);
        WinGameState state = new WinGameState(model);

        Viewer<MenuWinGame> viewer = state.getViewer();

        assertNotNull(viewer);
        assertTrue(viewer instanceof MenuWinGameViewer);
    }

    //Semelhante ao teste anterior, este verifica se o método getController() retorna uma instância correta de
    // MenuWinGameController. Isso é crucial para garantir que o controlador
    // adequado seja associado ao estado de vitória do jogo
    @Test
    void testGetController() {
        MenuWinGame model = mock(MenuWinGame.class);
        WinGameState state = new WinGameState(model);

        Controller<MenuWinGame> controller = state.getController();

        assertNotNull(controller);
        assertTrue(controller instanceof MenuWinGameController);
    }

}
