![Logo](logo.png)

# Boilerplate Java para Automação de Testes de Aplicações Web

O boilerplate Java para automação de testes de aplicações web contém um conjunto inicial de recursos que possibilitam um rápido e simplificado início de construção de testes automatizados utilizando a proposta "DB" do modelo [PageObject](https://martinfowler.com/bliki/PageObject.html).

## Getting started

### Pré-requisitos

- [Java SE Development Kit 11](https://www.oracle.com/br/java/technologies/downloads/#java11) ou superior
- [Gradle 6.8](https://docs.gradle.org/6.8/userguide/installation.html#installing_with_a_package_manager) ou superior (se superior, demanda atualização do Gradle Wrapper)

### Workspace

O workspace contém a seguinte estrutura:

```shell
.
├── gradle
└── src
    ├── main
    │   ├── java
    │   │   ├── app
    │   │   └── framework
    │   └── resources
    └── test
        ├── java
        │   ├── pageobjects
        │   ├── tasks
        │   ├── testcases
        │   └── validations
        └── resources
```

- `gradle` - Local da distribuição Gradle em utilização no projeto (Gradle Wrapper)
- `src` - Local dos arquivos de código fonte da codebase
  - `main` - Local que centraliza a parte da codebase a ser executada em formato de aplicação convencional (Java ou outras)
    - `java/app` - Local do web server que provê uma aplicação web de exemplo (cujos arquivos HTML, JavaScript e CSS estão em `main/resources/app`)
    - `java/framework` - Local da parte base do framework para automação de testes
    - `resources` - Local de arquivos utilitários (ex.: arquivos da aplicação web de exemplo, arquivos de dados, arquivos de propriedades para a aplicação)
  - `test` - Local que centraliza a parte da codebase a ser executada em formato de testes (Java ou outras, via frameworks como por exemplo JUnit)
    - `java/pageobjects` - Local complementar ao framework para automação de testes que possui as classes que representam as páginas da aplicação web alvo (ex.: aplicação provida pelo web server em `main/java/app`)
    - `java/tasks` - Local complementar ao framework para automação de testes que possui as classes que representam as ações de alto nível a serem efetuadas nas páginas da aplicação web alvo via `pageobjects`
    - `java/testcases` - Local complementar ao framework para automação de testes que possui as classes que representam os casos de teste de fato, através do uso em conjunto de `pageobjects`, `tasks` e `validations`
    - `java/validations` - Local complementar ao framework para automação de testes que possui as classes que representam as "assertions" (verificações de resultados)
    - `resources` - Local de arquivos utilitários para os testes (ex.: arquivos de dados, output padrão de relatórios de execução de testes, arquivos de propriedades para os testes)

> [!NOTE]
> As pastas intermediárias `java` contidas em `main` e `test` tem propósito de centralizar os arquivos Java. Essa convenção ajuda na organização do código e é flexível para suportar outras linguagens (Gradle suporta ambientes multi-linguagem). Se houvessem também arquivos em uma linguagem diferente, como por exemplo Kotlin, também poderia haver uma pasta correspondente (ex.: `kotlin`).

### Executando o projeto

#### 1. Aplicação

##### 1.1 Via terminal de comandos

Atualizar (sincronizar) as dependências configuradas no projeto
```shell
gradle --refresh-dependencies
```

Executar o arquivo `gradlew` usando a task **run** 
```shell
./gradlew run
```

#### 2. Testes

##### 2.1 Via terminal de comandos

Atualizar (sincronizar) as dependências configuradas no projeto
```shell
gradle --refresh-dependencies
```

Executar o arquivo `gradlew` usando a task **test** 
```shell
./gradlew test
```
