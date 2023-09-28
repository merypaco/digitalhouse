import http from "k6/http";
import { sleep } from "k6";
import { SharedArray } from "k6/data";

export const options = {
  thresholds: {
    http_req_failed: ["rate<0.01"],
    http_req_duration: ["p(95)<300"],
  },
};

const users = new SharedArray("users", function () {
  return JSON.parse(open("./users.json"));
});

export function setup() {
  const headers = {
    Accept: "application/json",
    "Content-Type": "application/json",
  };
  return {
    headers,
  };
}

export default function (data) {
  const headers = data["headers"];
  const payload = users.at(0);
  const response = http.post(__ENV.URL, JSON.stringify(payload), { headers });

  console.info(`status code: ${response.status}`);
  sleep(1);
}
