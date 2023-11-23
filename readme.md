## LDTS_T05G05 - PACXON

O "Pacxon" consiste na junção de dois jogos: PacMan e Xonix. O objetivo principal do jogo é preencher os espaços vazios e capturar os monstros construindo paredes à volta deles. O utilizador passa para o nível seguinte assim que preencher 80% do mapa. À medida que avança de nível a dificuldade aumenta.

Autores: Beatriz Pereira (up202207380), Francisca Fernandes (up202106509) e Francisco Lopes (up202108796) para LDTS 2023/24

### IMPLEMENTED FEATURES

- Menu: Oferece as funcionalidades de iniciar o jogo, pausá-lo, reiniciar, retomar e selecionar o nível do jogo;
- Movimento do PacMan: O utilizador consegue movimentar o PacMan através das teclas convencionais do seu computador;
- Movimento dos Monstros: Os Monstros movimentam-se automaticamente, de forma aleatória;
- Colisão entre o PacMan e os Monstros: Quando o PacMan e os Monstros colidem, o PacMan perde uma vida e tem de recomeçar o nível em que se encontra. Caso seja a sua última vida, perde o jogo;
- Boosts do PacMan: elementos que aparecem aleatoriamente em cada nível e que, assim que o PacMan os alcance, melhoram a sua performance (aumentam a sua velocidade, congelam os Monstros, atribuem vidas extra, etc.);
- Preenchimento dos blocos: O caminho que o PacMan percorre vai preenchendo os blocos do mapa desde que não colida com nenhum monstro.

### PLANNED FEATURES

- Introdução de monstros novos à medida que avança de nível;
- Música de fundo e sons do jogo (colisão com um monstro, captura de um boost, etc.);

### DESIGN

> This section should be organized in different subsections, each describing a different design problem that you had to solve during the project. Each subsection should be organized in four different parts:

- **Problem in Context.** The description of the design context and the concrete problem that motivated the instantiation of the pattern. Someone else other than the original developer should be able to read and understand all the motivations for the decisions made. When refering to the implementation before the pattern was applied, don’t forget to [link to the relevant lines of code](https://help.github.com/en/articles/creating-a-permanent-link-to-a-code-snippet) in the appropriate version.
- **The Pattern.** Identify the design pattern to be applied, why it was selected and how it is a good fit considering the existing design context and the problem at hand.
- **Implementation.** Show how the pattern roles, operations and associations were mapped to the concrete design classes. Illustrate it with a UML class diagram, and refer to the corresponding source code with links to the relevant lines (these should be [relative links](https://help.github.com/en/articles/about-readmes#relative-links-and-image-paths-in-readme-files). When doing this, always point to the latest version of the code.
- **Consequences.** Benefits and liabilities of the design after the pattern instantiation, eventually comparing these consequences with those of alternative solutions.

**Example of one of such subsections**:

------

#### THE JUMP ACTION OF THE KANGAROOBOY SHOULD BEHAVE DIFFERENTLY DEPENDING ON ITS STATE

**Problem in Context**

There was a lot of scattered conditional logic when deciding how the KangarooBoy should behave when jumping, as the jumps should be different depending on the items that came to his possession during the game (an helix will alow him to fly, driking a potion will allow him to jump double the height, etc.). This is a violation of the **Single Responsability Principle**. We could concentrate all the conditional logic in the same method to circumscribe the issue to that one method but the **Single Responsability Principle** would still be violated.

**The Pattern**

We have applied the **State** pattern. This pattern allows you to represent different states with different subclasses. We can switch to a different state of the application by switching to another implementation (i.e., another subclass). This pattern allowed to address the identified problems because […].

**Implementation**

The following figure shows how the pattern’s roles were mapped to the application classes.

![img](https://www.fe.up.pt/~arestivo/page/img/examples/lpoo/state.svg)

These classes can be found in the following files:

- [Character](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/Character.java)
- [JumpAbilityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/JumpAbilityState.java)
- [DoubleJumpState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/DoubleJumpState.java)
- [HelicopterState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/HelicopterState.java)
- [IncreasedGravityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/IncreasedGravityState.java)

**Consequences**

The use of the State Pattern in the current design allows the following benefits:

- The several states that represent the character’s hability to jump become explicit in the code, instead of relying on a series of flags.
- We don’t need to have a long set of conditional if or switch statements associated with the various states; instead, polimorphism is used to activate the right behavior.
- There are now more classes and instances to manage, but still in a reasonable number.

#### KNOWN CODE SMELLS

> This section should describe 3 to 5 different code smells that you have identified in your current implementation.

### TESTING

- Screenshot of coverage report.
- Link to mutation testing report.

### SELF-EVALUATION

> In this section describe how the work regarding the project was divided between the students. In the event that members of the group do not agree on a work distribution, the group should send an email to the teacher explaining the disagreement.

**Example**:

- John Doe: 40%
- Jane Doe: 60%
