require 'sinatra'
require 'sqlite3'

get '/user/:id' do
  user_id = params[:id]
  
  # Potential SQL injection
  db = SQLite3::Database.new 'test.db'
  db.execute("SELECT * FROM users WHERE id = '#{user_id}'")
  
  # Potential command injection
  system("echo #{params[:name]}")
  
  # Potential XSS
  "<html><body>User: #{params[:name]}</body></html>"
end

post '/exec' do
  # Potential command injection
  `#{params[:command]}`
end
