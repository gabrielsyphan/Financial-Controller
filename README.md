# Financial App

Projeto de controle financeiro desenvolvido em Kotlin com Spring Boot.

## Pré-requisitos

- Docker instalado na máquina
- IntelliJ IDEA (ou outro IDE compatível) ou Gradle

## Como executar

1. **Suba os serviços necessários (MySQL, Kafka, Redpanda Console, etc):**

   ```sh
   docker compose -f docker-compose-kafka.yml up -d
    ```
2. **Caso prefira usar Redpanda, suba os serviços necessários (MySQL, Redpanda, Redpanda Console, etc):**

   ```sh
   docker compose -f docker-compose-redpanda.yml up -d
   ```
3. **Execute a aplicação:**

   - Usando IntelliJ IDEA: Importe o projeto e execute a classe `FinancialAppApplication.kt`.
   - Usando Gradle: Navegue até o diretório do projeto e execute:

     ```sh
     ./gradlew bootRun
     ```
4. **Acesse a aplicação em `http://localhost:2984`.**

## Contribuição
Sinta-se à vontade para contribuir com melhorias ou correções. Faça um fork do repositório, crie uma branch para sua feature e envie um pull request.
