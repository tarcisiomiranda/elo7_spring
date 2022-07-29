from flask import Flask, render_template, request, send_from_directory
import requests
import json
import sys

app = Flask(__name__, template_folder='html')

@app.route('/', methods=['GET'])
def index():
    url1 = 'http://192.168.28.20:8080/sondas/trip/1'
    url2 = 'http://192.168.28.20:8080/sondas/trip/2'
    data1 = {'command': 'LMLMLMLMM'}
    data2 = {'command': 'MMRMMRMRRML'}
    res1 = requests.post(url1, json = data1)
    res2 = requests.post(url2, json = data2)
    rjson1 = json.loads(res1.text)
    rjson2 = json.loads(res2.text)
    sonda1 = rjson1['name']
    sonda2 = rjson2['name']
    todas = True

    return render_template(
        'sondas.html', sonda1=sonda1, sonda2=sonda2, res1=rjson1, res2=rjson2, todas=todas
        )

@app.route('/sonda1', methods=['GET'])
def sonda1():
    url = 'http://192.168.28.20:8080/sondas/trip/1'
    data = {'command': 'LMLMLMLMM'}
    res = requests.post(url, json = data)
    return render_template(
        'sondas.html', sonda='Sonda 1', res=res.text, todas=False
        )

@app.route('/sonda2', methods=['GET'])
def sonda2():
    url = 'http://192.168.28.20:8080/sondas/trip/2'
    data = {'command': 'MMRMMRMRRML'}
    res = requests.post(url, json = data)
    return render_template(
        'sondas.html', sonda='Sonda 2', res=res.text, todas=False
        )

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5009, debug=True)
