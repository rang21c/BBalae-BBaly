# 빨래빨리

- 프로젝트명 : 빨래빨리
- 개요 : 광운대학교 기숙사 학생들을 위하여 세탁/건조기 작동 시 발생하는 진동을 통해 세탁/건조기의 사용유무를 판단하는 아두이노 모듈과 어플리케이션을 개발한다.

## 시스템 구조도
![image](https://user-images.githubusercontent.com/33370179/174574521-a5e08c7a-5252-4fd4-9ed1-43a63063302d.png)

## 모듈 설명
### Arduino

#### 사용 부품
아두이노 Wemos D1 R1(WiFi)

SW-420 진동 감지 센서

#### 사용 방식
세탁/건조기 옆면에 부착하여 사용

#### 작동 방식
매초 측정되는 진동 값을 이용하여 세탁/건조기 작동 여부 판별 알고리즘을 적용한 후 결과 값을 파이어베이스 실시간DB에 전송

---

### Firebase
<img src="https://user-images.githubusercontent.com/33370179/174575531-295fc150-0137-4c14-82e7-a6bf7cec4f28.png" width="400" height="320"/><img src="https://user-images.githubusercontent.com/33370179/174575542-13195b36-8762-46db-8e07-139475ab8f7d.png" width="340" height="300"/>

총 2대의 세탁기, 2대의 건조기 데이터를 담을 수 있게 설계

각 기기 트리 내부 Key값에는 count, hour, minute, status가 존재

- count : 진동 감지 횟수
- hour : 세탁/건조기 종료 예정 시간
- minute : 세탁/건조기 종료 예정 시간
- status : 세탁/건조기 작동 여부

![image](https://user-images.githubusercontent.com/33370179/174576700-85e9d594-5de6-4f44-bd79-64505a9fad02.png)

---

### Android

Kotlin을 사용하여 제작 - 원페이지 어플리케이션

<img src="https://user-images.githubusercontent.com/33370179/174576841-a9403630-18a7-4ca6-bc51-b841a3d73273.png" width="300" height="500"/>   <img src="https://user-images.githubusercontent.com/33370179/174576851-6754c9c0-7728-4a9f-b022-8bcfcd229bf6.png" width="300" height="500"/>


---


## 시연동영상
세탁/건조 시작 시

[![image](https://user-images.githubusercontent.com/33370179/174578237-58debad5-137e-42d9-9b4c-5e390b5186ec.png)](https://youtu.be/cq7c3yvnx0M)

세탁/건조 종료 시

[![image](https://user-images.githubusercontent.com/33370179/174578405-e2d48616-df35-4db0-84c5-e2b293c76bf8.png)](https://www.youtube.com/watch?v=FKocxYjqaSo)
