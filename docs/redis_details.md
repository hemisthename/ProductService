1	Install WSL

Click on the Start menu →  Command Prompt (Admin)
wsl --install

2	Install redis-server
wsl
sudo apt update
sudo apt install redis-server

3	Server StartUp
redis-server
4	If port is already used	
sudo lsof -i :6379
sudo kill -9 <PID>

5	if already started	redis-cli