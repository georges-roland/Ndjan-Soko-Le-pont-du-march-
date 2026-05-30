# 🌿 Ndjan-Soko - Le Pont du Marché

Projet Bachelor 2 - Keyce IA | Promotion 2024

## 🏗️ Architecture du projet

```
ndjan-soko/
├── backend/        → Spring Boot (Java 17)
└── frontend/       → React (JavaScript)
```

## ⚡ Démarrage rapide

### Backend
```bash
cd backend
# Créer la base PostgreSQL d'abord :
# createdb ndjansoko_db
mvn spring-boot:run
# → API disponible sur http://localhost:8080
```

### Frontend
```bash
cd frontend
npm install
npm start
# → App disponible sur http://localhost:3000
```

## 👥 Répartition de l'équipe

| Membre | Backend | Frontend |
|--------|---------|----------|
| **F** (Chef) | `modules/auth/` + JWT + Config | `pages/auth/` + App.jsx + AuthContext |
| **R** | `modules/harvest/` + `modules/pricing/` | `pages/farmer/` + `pages/buyer/MarketPricePage` |
| **B** | `modules/logistics/` | `pages/transporter/` |
| **D** | `modules/payment/` + SHA-256 Ledger | `pages/buyer/PaymentEscrowPage` |
| **A** | `modules/ussd/` + `config/SecurityConfig` | `pages/admin/AdminSecurityPage` |

## 📋 Règles d'intégration

1. **Ne jamais toucher** au code d'un autre membre sans le prévenir
2. **apiClient.js** : ne pas modifier (géré par F)
3. **AuthContext.jsx** : ne pas modifier (géré par F)
4. **App.jsx** : ne pas modifier sans F
5. Chaque module backend est **indépendant** → pas de conflits Git
