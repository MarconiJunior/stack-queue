# Sistema de Navegação de Browser e Gerenciamento de Fila de Pacientes

## Descrição
Este sistema simula dois componentes:
1. **Navegação de Browser**: Permite navegar entre páginas, com opções de voltar e avançar utilizando uma pilha.
2. **Gerenciamento de Fila de Pacientes**: Registra pacientes em uma fila e chama os pacientes na ordem de chegada utilizando uma fila.

## Funcionalidades
- **Navegação de Browser**:
  - Voltar e avançar nas páginas visitadas.
  - Registrar nova página e limpar o histórico de avanço.
  
- **Gerenciamento de Fila de Pacientes**:
  - Registrar pacientes na fila com nome e ID único.
  - Chamar pacientes da fila na ordem correta.
  - Visualizar pacientes já chamados.

## Estruturas de Dados Utilizadas
- **Pilha (Stack)**: Para gerenciar a navegação de páginas no navegador.
- **Fila (Queue)**: Para gerenciar o atendimento de pacientes.

## Tecnologias Utilizadas
- **Java**: Linguagem principal de implementação.
- **Swing**: Biblioteca para a interface gráfica.

## Testes
- Testes de navegação entre páginas.
- Testes de registro e atendimento de pacientes.
- Testes da interface gráfica para interação do usuário.

## Como Executar
1. Compile e execute o código Java.
2. A interface gráfica permitirá registrar pacientes e navegar entre páginas.
