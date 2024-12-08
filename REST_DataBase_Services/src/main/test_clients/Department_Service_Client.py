import json

import requests

from typing import Dict
from http import HTTPStatus
from requests import Response


url: str = 'http://0.0.0.0:8083/'
rest_url: str = f'{url}'

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


def get_departments():
    response: Response = requests.get(url=f'{rest_url}/departments')
    print_response(response)


def add_departments(postfix: int = 1):
    headers: Dict = {
        'SomeParam': 'SomeValue',
        'Location': 'UAE',
        str(HTTPHeader.ContentType): 'application/json'
    }
    json_data: Dict = {
        'departmentName': f'Test_Department_{postfix}',
        'departmentAddress': f'Block-{postfix}',
        'departmentCode': str(1000 + postfix)
    }
    response: Response = requests.post(url=f'{rest_url}/departments',
                                       headers=headers,
                                       json=json_data)
    print_response(response)


def delete_departments(department_id: int):
    response: Response = requests.delete(url=f'{rest_url}/departments/{department_id}')
    print_response(response)


if __name__ == '__main__':
    # get_departments()
    add_departments(5)
    # delete_departments(3)
