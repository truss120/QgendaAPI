import requests

##GET TOKEN##
login = {'email': 'bcmAPI@qgenda.com', 'password': 'p4I?8*emz#zOonIP'}
response = requests.post('https://api.qgenda.com/v2/login', data=login)
#print(response.text)


##DEFINE HEADERS##
token = response.json()['token_type'] + " " + response.json()['access_token']
header = {'Authorization': token, 'Content-Type': 'application/json', 'Accept-Encoding': '*'}
#print(header)
#print(token)

