package org.example.thuan;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HelloServlet extends HttpServlet {

    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss · dd/MM/yyyy");

    private static final String PAGE = """
            <!doctype html>
            <html lang="vi">
            <head>
              <meta charset="UTF-8">
              <meta name="viewport" content="width=device-width, initial-scale=1">
              <title>Hello World</title>
              <style>
                :root {
                  --bg-1: #eef2ff; --bg-2: #fdf2f8;
                  --card: #ffffff; --text: #1e1b4b; --muted: #6b7280;
                  --accent-1: #6366f1; --accent-2: #ec4899; --line: #e5e7eb;
                }
                @media (prefers-color-scheme: dark) {
                  :root {
                    --bg-1: #0f0d1f; --bg-2: #1a0f1c;
                    --card: #18162b; --text: #f5f3ff; --muted: #a1a1aa;
                    --line: #2e2a47;
                  }
                }
                * { box-sizing: border-box; }
                body {
                  margin: 0; min-height: 100vh;
                  display: grid; place-items: center; padding: 24px 16px;
                  font-family: system-ui, -apple-system, "Segoe UI", Roboto, sans-serif;
                  color: var(--text);
                  background: linear-gradient(135deg, var(--bg-1), var(--bg-2));
                }
                .card {
                  width: 100%%; max-width: 440px;
                  background: var(--card);
                  border: 1px solid var(--line);
                  border-radius: 20px;
                  padding: 40px 32px;
                  text-align: center;
                  box-shadow: 0 20px 50px -20px rgba(79, 70, 229, 0.35);
                  animation: rise .6s ease-out;
                }
                @keyframes rise { from { opacity: 0; transform: translateY(12px); } }
                .wave { font-size: 48px; display: inline-block; animation: wave 2s ease-in-out infinite; transform-origin: 70%% 70%%; }
                @keyframes wave { 0%%, 60%%, 100%% { transform: rotate(0); } 10%%, 30%% { transform: rotate(14deg); } 20%%, 40%% { transform: rotate(-8deg); } }
                h1 {
                  margin: 12px 0 8px; font-size: 40px; letter-spacing: -0.03em;
                  background: linear-gradient(90deg, var(--accent-1), var(--accent-2));
                  -webkit-background-clip: text; background-clip: text; color: transparent;
                }
                p { margin: 0; color: var(--muted); }
                .info {
                  margin-top: 28px; padding-top: 20px; border-top: 1px solid var(--line);
                  display: grid; grid-template-columns: auto 1fr; gap: 8px 16px;
                  text-align: left; font-size: 14px;
                }
                .info dt { color: var(--muted); }
                .info dd { margin: 0; font-weight: 500; text-align: right; }
              </style>
            </head>
            <body>
              <main class="card">
                <span class="wave">👋</span>
                <h1>Hello World</h1>
                <p>Embedded Tomcat đang chạy ngon lành.</p>
                <dl class="info">
                  <dt>Máy chủ</dt><dd>%s</dd>
                  <dt>Java</dt><dd>%s</dd>
                  <dt>Thời gian</dt><dd>%s</dd>
                </dl>
              </main>
            </body>
            </html>
            """;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String html = PAGE.formatted(
                getServletContext().getServerInfo(),
                System.getProperty("java.version"),
                LocalDateTime.now().format(TIME_FORMAT));

        resp.getWriter().write(html);
    }
}
