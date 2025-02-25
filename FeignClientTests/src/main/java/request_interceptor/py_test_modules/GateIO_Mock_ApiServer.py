
import time
import uvicorn
from fastapi import FastAPI, APIRouter


class APIServer(object):

    def __init__(self):
        self.router = APIRouter()
        self.router.add_api_route(path="/api/v4/auth", methods=["GET"],
                                  endpoint=self.auth)
        self.router.add_api_route(path="/api/v4/wallet/sub_account_futures_balances", methods=["GET"],
                                  endpoint=self.wallet_account_balances)

    async def auth(self,
                   accountId: str):
        return { 'id': accountId, 'result': 'OK'}

    async def wallet_account_balances(self,
                                      accountId: str):
        return { 'id': accountId, 'balances': []}


if __name__ == '__main__':
    api: FastAPI = FastAPI()
    server = APIServer()
    api.include_router(server.router)
    uvicorn.run(api, host="0.0.0.0", port=50002, log_level="debug")

    # INFO:  Swagger | http://0.0.0.0:50002/docs
