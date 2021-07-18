구성 :
Language : Kotlin
AAC(MVVM, ViewBinding, LiveData, Navigation)
Opensource: Coroutine, Retrofit, okhttp, Glide, GSON, ViewModelScope

소개: 
과제에서 주어진 요구사항을 만족하기 위해 2개의 Fragment를  jetpack-navigation을 통해 구현하였습니다.
또한 Infinity Scroll 기능을 구현하기 위해 paging 라이브러리와 ScrollListener를 통한 구현법을 
고려해 보았고 ScrollListener 방법으로 구현하였습니다. 제품리스트 사이에 추천리스트 삽입 하는 요구조건에서
https://s3.ap-northeast-2.amazonaws.com/public.glowday.com/test/app/recommend_product.json API 요청 후 
응답 파라미터가 리스트로 넘어오지 않아 확장성을 고려하지 못하여 11번째 21번째 31번째 postion을 하드코딩하였습니다.
2개의 API는 비동기로 구성 하는 요구조건은 viewModelScope 안에서 await() 함수를 통하여 구현하였습니다.


