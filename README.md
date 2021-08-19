# LibraryBoard

- ## API 명세서

  + ### 회원가입
      URL : POST /login/signup
      권한 : All
      
      요청
      ```
      {
          "email" : "bbb@bbbb.bbb",
          "password" : "aaa",
          "name" : "user1",
          "phone" : "010-0000-1111"
      }
      ```
      
      응답
      ```
      {
          "seq": 2,
          "email": "bbb@bbbb.bbb",
          "password": "$2a$10$cUDUP1eGuB8bhyeAzA87Iua4/bQDc4MqXD.wm1ewkt1QSHLImBFHu",
          "name": "user1",
          "authority": "ROLE_USER",
          "phone": "010-0000-1111",
          "joinAt": "2021-08-18T18:50:55.0644711"
      }
      ```
      
  + ### 로그인  
      URL : POST /login/signup
      권한 : All
      
      요청
      ```
      {
          "email" : "bbb@bbbb.bbb",
          "password" : "aaa"
      }
      ```
      
      응답
      ```
      {
          "token": "eyJhdXRoLXRva2VuIjoiand0IiwiYWxnIjoiSFM1MTIifQ.eyJzdWIiOiJjb20uanllb24ubGlicmFyeS5tb2RlbC5BdXRoVXNlckA2MGRmYjNkNCIsImV4cCI6MTYyOTM0NDY2NH0.Ux79VDufeoghCRdydrxn0GICKdfprg7qUhIAcz9elTB44_dcyOQnts6w4cgg86zVFk6GE63uIehMQU8UZjCmEw"
      }
      ```
   
   + ### 책 목록보기
      URL : GET /book/list?page=0&size=2
      권한 : All
      
      응답
      ```
      [
          {
              "seq": 1,
              "title": "title1",
              "author": "author1",
              "publisher": "poublisher1",
              "description": "description1",
              "classification": "GENERAL",
              "totStarPoint": 25,
              "totStarCount": 5,
              "publishingDate": "2021-07-01T12:53:00",
              "receivingDate": "2021-07-01T12:53:00",
              "createAt": "2021-08-19T11:50:43.933954"
          },
          {
              "seq": 2,
              "title": "title2",
              "author": "author2",
              "publisher": "poublisher2",
              "description": "description2",
              "classification": "ART",
              "totStarPoint": 0,
              "totStarCount": 0,
              "publishingDate": "2021-07-01T12:53:00",
              "receivingDate": "2021-07-01T12:53:00",
              "createAt": "2021-08-19T11:50:43.933954"
          }
      ]
      ```

  + ### 책 작성하기 
      URL : POST /book/post
      권한 : Admin
      Autorization bearer token 입력
      
      요청
      ```
      {
          "title" : "hi",
          "author" : "iam",
          "publisher" : "home",
          "description" : "fun",
          "classification" : "LITERATURE",
          "publishingDate" : "2021-07-01T12:53:00",
          "receivingDate" : "2021-07-01T12:53:00"
      }
      ```
      
      응답
      ```
      {
          "seq": 3,
          "title": "hi",
          "author": "iam",
          "publisher": "home",
          "description": "fun",
          "classification": "LITERATURE",
          "totStarPoint": 0,
          "totStarCount": 0,
          "publishingDate": "2021-06-01T23:45:00",
          "receivingDate": "2021-06-01T23:45:00",
          "createAt": "2021-08-18T12:18:03.1067781"
      }
      ```

  + ### 책 별점주기
      URL : GET /book/{1}/star?point=5
      권한 : User
      Autorization bearer token 입력
      
      응답
      ```
      {
          "seq": 1,
          "title": "title1",
          "author": "author1",
          "publisher": "poublisher1",
          "description": "description1",
          "classification": "GENERAL",
          "totStarPoint": 25,
          "totStarCount": 5,
          "publishingDate": "2021-07-01T12:53:00",
          "receivingDate": "2021-07-01T12:53:00",
          "createAt": "2021-08-18T18:50:43.933954"
      }
      ```
