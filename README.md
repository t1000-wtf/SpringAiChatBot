Ola a voce usuario eu sou o dev 
 _______  ____   ____  _____  _____ _   _ _   _ _   _  ___  
|__   __|/ __ \ / __ \|  __ \|_   _| \ | | | | | | | |/ _ \ 
   | |  | |  | | |  | | |__) | | | |  \| | | | | | | | | | |
   | |  | |  | | |  | |  _  /  | | | . ` | | | | | | | | | |
   | |  | |__| | |__| | | \ \ _| |_| |\  | |_| | |_| | |_| |
   |_|   \____/ \____/|_|  \_\_____|_| \_|\___/ \___/ \___/ 

   e vou esse chatbot funcionaç, para isso voce precisa colocar no  ChatService um prompt com as funções que voce espera que ele tenha e caso queira conectar ele a um site ou banco de dados voce pode usar o AssistantTools para isso, e lembre de criar um .env com todas as keys necessarias para se conectar a LLM do gemini e ao do telegram

## Executar

1. Se ainda não existir, copie `.env.example` para `.env`; preencha `GEMINI_API_KEY` no arquivo.
2. Para habilitar o bot do Telegram, preencha `TELEGRAM_BOT_TOKEN` e defina `TELEGRAM_ENABLED=true`. Sem isso, o polling fica desativado.
3. Inicie a aplicação com `.\mvnw.cmd spring-boot:run`.

O endpoint `POST /api/assistant` recebe JSON no formato `{"message":"Sua mensagem"}` e retorna a resposta do assistente como texto.