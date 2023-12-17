## LDTS_T05G05 - PACXON

O "Pacxon" consiste na junção de dois jogos: PacMan e Xonix. O objetivo principal do jogo é preencher os espaços vazios e capturar os monstros construindo paredes à volta deles. O utilizador passa para o nível seguinte assim que preencher 80% do mapa. À medida que avança de nível a dificuldade aumenta.

Autores: Beatriz Pereira (up202207380), Francisca Fernandes (up202106509) e Francisco Lopes (up202108796) para LDTS 2023/24

### IMPLEMENTED FEATURES

- Menu: Oferece as funcionalidades de iniciar o jogo, ver como jogar, ver as regras e sair;
- Movimento do PacMan: O utilizador consegue movimentar o PacMan através das teclas convencionais do seu computador;
- Movimento dos Monstros: Os Monstros movimentam-se automaticamente, de forma aleatória;
- Colisão entre o PacMan e os Monstros: Quando o PacMan e os Monstros colidem, o PacMan perde uma vida e tem de recomeçar o nível em que se encontra. Caso seja a sua última vida, perde o jogo;
- Preenchimento dos blocos: O caminho que o PacMan percorre vai preenchendo os blocos do mapa desde que não colida com nenhum monstro.
- Música de fundo;


### PLANNED FEATURES
- Menu: pausá-lo, reiniciar, retomar e selecionar o nível do jogo;
- Boosts do PacMan: elementos que aparecem aleatoriamente em cada nível e que, assim que o PacMan os alcance, melhoram a sua performance (aumentam a sua velocidade, congelam os Monstros, atribuem vidas extra, etc.);


### DESIGN

- **Problem in Context.** Durante o desenvolvimento do Pacxon, deparámo-nos com o desafio de gerir diferentes estados do jogo, tais como o menu, a jogabilidade e as situações de fim de nível.
- **The Pattern.** Para solucionar isso, decidimos implementar o pattern de design State. Este pattern é ideal para cenários onde o comportamento de um objeto muda com base no seu estado interno. Ao encapsular os comportamentos específicos de cada estado em classes separadas, conseguimos simplificar as transições e interações entre os diferentes estados do jogo.
- **Implementation.** Criámos classes base abstratas para cada estado, como MenuState e GameState e implementámos os comportamentos específicos nas suas subclasses respectivas. Esta estrutura facilitou a mudança entre estados e tornou o código mais modular e legível.

**Classes:**
- [MenuState](https://github.com/FEUP-LDTS-2023/project-l05gr05/blob/main/src/main/java/com/aor/pacxon/states/MenuState.java)
- [GameState](https://github.com/FEUP-LDTS-2023/project-l05gr05/blob/main/src/main/java/com/aor/pacxon/states/GameState.java)

**Consequences:**

A aplicação do padrão State melhorou significativamente a manutenção e escalabilidade do jogo Pacxon. Cada estado do jogo pode agora ser modificado independentemente sem afetar os outros, facilitando futuros aprimoramentos e correções de bugs. No entanto, esta abordagem introduziu classes adicionais, o que aumentou ligeiramente a complexidade da base de código. Apesar disso, os benefícios de uma maior modularidade e adesão aos princípios de design superaram as desvantagens.


### Known-code smells

Corrigimos todos os code smells, não encontramos nenhum significativo.

### Link to testing report
[Testing Report](../build/reports/tests/test/index.html)

### SELF-EVALUATION

- Beatriz Pereira: 33%
- Francisca Fernandes: 33%
- Francisco Lopes: 33%
