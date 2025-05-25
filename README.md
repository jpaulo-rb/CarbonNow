# CarbonNow - Simulador de Impacto Ambiental (CO₂)

*Projeto criado para fins acadêmicos.*

Aplicativo Android que simula a emissão de carbono gerada por atividades cotidianas, como consumo de eletricidade ou envios de produtos.  
Seu objetivo é informar os usuários sobre o impacto ambiental de suas escolhas, incentivando decisões mais conscientes.

---

## Funcionalidades

- Escolha do tipo de atividade: **eletricidade** ou **entregas (shipping)**.
- Inserção dos dados solicitados (como consumo ou distância).
- Consulta à **API Carbon Interface** e exibição da emissão estimada de CO₂.

---

## Tecnologias e Arquitetura

- **Kotlin + Jetpack Compose** — UI declarativa moderna  
- **Navigation Compose** — Navegação entre telas  
- **LiveData** — Observação reativa dos dados  
- **Retrofit + Gson** — Integração com API REST  
- **Arquitetura MVVM** — Separação entre Model, View e ViewModel
