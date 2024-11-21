import json

import requests
from typing import Dict

from requests import Response

from Networking.ApiClients_Spring.HTTPHeader import HTTPHeader
from TII_Experiments.ELF.ELFAnalyzer import headers

url: str = 'http://0.0.0.0:8080/'
endpoint: str = 'employees'
rest_url: str = f'{url}/{endpoint}'


class HTTPHeader(str, Enum):
    Authorization = 'Authorization'
    AcceptLanguage = 'Accept-Language'
    Host = 'Host'
    UserAgent = 'User-Agent'
    ContentType = 'Content-Type'
    ContentLength = 'Content-Length'

    def __str__(self):
        return self.value



def print_response(response: Response):
    if HTTPStatus.OK == response.status_code:
        if 'application/json' == response.headers.get(HTTPHeader.ContentType):
            print(json.dumps(response.json(), indent=4))
    else:
        print(f"Error {response.status_code}")
        print(response.text)


def get_all_employees():
    response: Response = requests.get(url=rest_url + "/")
    print_response(response)


def post_add_employee():
    headers: Dict = {
        'X-COM-PERSIST': 'SomeValue',
        'X-COM-LOCATION': 'UAE',
        str(HTTPHeader.ContentType): 'application/json'
    }
    json_data: Dict = {
        'id': 1001,
        'firstName': 'John',
        'lastName': 'Dow',
        'email': 'john-dow@gmail.com'
    }
    response: Response = requests.post(url=rest_url + "/",
                                       headers=headers,
                                       json=json_data)
    print_response(response)


if __name__ == '__main__':
    post_add_employee()
    get_all_employees()
