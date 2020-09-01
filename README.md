![test](https://github.com/uehr/uKA/workflows/test/badge.svg)
![release](https://github.com/uehr/uKA/workflows/release/badge.svg)

### Twitterトレンド予測ゲーム | uKA
[uka.uehr.co | 本番](https://uka.uehr.co)  
[uka-stg.uehr.co | ステージング](https://uka-stg.uehr.co)  
[Wiki](https://github.com/uehr/uKA/wiki)

### アーキテクチャ
![uKAアーキテクチャ](https://user-images.githubusercontent.com/26696733/91910092-5a047c80-ece9-11ea-92e9-2f6891d52a38.png)

### 開発ステータス
- [x] サーバレスインフラ構築（AWS）
- [x] CI/CD テスト（GitHubActions）
- [x] CI/CD リリース（GitHubActions）
- [x] アクセス解析（GoogleAnalytics）
- [x] TwitterAPI連携（SpringBoot）
- [ ] エラー監視（Sentry）
- [ ] API実装（SpringBoot）
- [ ] テスト実装（SpringBoot）
- [ ] フロントアプリ実装（Vue.js）

### ローカル起動
1. 以下4つの環境変数をセット
    - UKA_TWITTER_ID
    - UKA_TWITTER_SECRET
    - UKA_TWITTER_TOKEN
    - UKA_TWITTER_TOKEN_SECRET

2. `docker-compose up`