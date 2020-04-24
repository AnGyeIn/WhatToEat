package com.agistudio97.whattoeat

import com.agistudio97.whattoeat.ConstData.CHINESE
import com.agistudio97.whattoeat.ConstData.FASTFOOD
import com.agistudio97.whattoeat.ConstData.JAPANESE
import com.agistudio97.whattoeat.ConstData.KOREAN
import com.agistudio97.whattoeat.ConstData.OTHER
import com.agistudio97.whattoeat.ConstData.WESTERN

class FoodData {
    val foodarray = arrayOf(
        //한식
        Food("닭갈비", KOREAN).apply {
            addIngredient("닭고기")
        },
        Food("삼겹살", KOREAN).apply {
            addIngredient("삼겹살")
        },
        Food("갈비", KOREAN).apply {
            addIngredient("갈비")
        },
        Food("소고기", KOREAN).apply {
            addIngredient("소고기")
        },
        Food("쫄면", KOREAN).apply {
            addIngredient("쫄면")
        },
        Food("막국수", KOREAN).apply {
            addIngredient("메밀국수")
        },
        Food("국밥(순대, 수육, 돼지, 소머리, 콩나물)", KOREAN).apply {
            addIngredient("국밥")
        },
        Food("갈비탕", KOREAN).apply {
            addIngredient("갈비")
        },
        Food("뼈해장국", KOREAN).apply {
            addIngredient("뼈해장국")
        },
        Food("떡갈비", KOREAN).apply {
            addIngredient("소고기")
        },
        Food("매운갈비찜", KOREAN).apply {
            addIngredient("갈비")
        },
        Food("족발", KOREAN).apply {
            addIngredient("족발")
        },
        Food("보쌈", KOREAN).apply {
            addIngredient("돼지고기")
        },
        Food("부대찌개", KOREAN).apply {
            addIngredient("햄")
        },
        Food("찜닭", KOREAN).apply {
            addIngredient("닭고기")
        },
        Food("낙지덮밥", KOREAN).apply {
            addIngredient("낙지")
        },
        Food("쭈꾸미덮밥", KOREAN).apply {
            addIngredient("쭈꾸미")
        },
        Food("닭볶음탕", KOREAN).apply {
            addIngredient("닭고기")
        },
        Food("닭삼겹", KOREAN).apply {
            addIngredient("닭고기")
        },
        Food("닭발", KOREAN).apply {
            addIngredient("닭발")
        },
        Food("떡볶이", KOREAN).apply {
            addIngredient("떡")
            addIngredient("어묵")
        },
        Food("막창", KOREAN).apply {
            addIngredient("막창")
        },
        Food("곱창", KOREAN).apply {
            addIngredient("곱창")
        },
        Food("대창", KOREAN).apply {
            addIngredient("대창")
        },
        Food("순대", KOREAN).apply {
            addIngredient("순대")
        },
        Food("김치찌개", KOREAN).apply {
            addIngredient("김치")
        },
        Food("된장찌개", KOREAN).apply {
            addIngredient("된장")
        },
        Food("청국장", KOREAN).apply {
            addIngredient("청국장")
        },
        Food("순두부찌개", KOREAN).apply {
            addIngredient("순두부")
        },
        Food("육개장", KOREAN).apply {
            addIngredient("소고기")
        },
        Food("알탕", KOREAN).apply {
            addIngredient("명란")
        },
        Food("육회", KOREAN).apply {
            addIngredient("소고기")
        },
        Food("김밥", KOREAN).apply {
            addIngredient("김")
            addIngredient("밥(쌀)")
        },
        Food("만두(군, 물, 찐, 튀김, 전골)", KOREAN).apply {
            addIngredient("만두")
        },
        Food("볶음밥(김치, 새우, 게살, 계란)", KOREAN).apply {
            addIngredient("밥(쌀)")
        },
        Food("비빔밥", KOREAN).apply {
            addIngredient("밥(쌀)")
        },
        Food("생선(조림, 구이, 튀김)", KOREAN).apply {
            addIngredient("생선")
        },
        Food("제육볶음", KOREAN).apply {
            addIngredient("돼지고기")
        },
        Food("불고기", KOREAN).apply {
            addIngredient("소고기")
        },
        Food("삼계탕", KOREAN).apply {
            addIngredient("닭고기")
        },
        Food("닭국수", KOREAN).apply {
            addIngredient("닭고기")
        },
        Food("오리주물럭", KOREAN).apply {
            addIngredient("오리고기")
        },
        Food("훈제오리", KOREAN).apply {
            addIngredient("오리고기")
        },
        Food("전복죽", KOREAN).apply {
            addIngredient("전복")
        },
        Food("돼지김치찜", KOREAN).apply {
            addIngredient("돼지고기")
        },
        Food("양념게장", KOREAN).apply {
            addIngredient("게")
        },
        Food("간장게장", KOREAN).apply {
            addIngredient("게")
        },
        Food("대게", KOREAN).apply {
            addIngredient("대게")
        },
        Food("튀김", KOREAN).apply {
            addIngredient("밀가루")
        },
        Food("조개구이", KOREAN).apply {
            addIngredient("조개")
        },
        Food("해물탕(찜)", KOREAN).apply {
            addIngredient("해물")
        },
        Food("아구탕(찜)", KOREAN).apply {
            addIngredient("아구")
        },
        Food("떡만둣국", KOREAN).apply {
            addIngredient("떡")
            addIngredient("만두")
        },
        Food("국수(잔치, 비빔, 김치말이, 칼, 콩)", KOREAN).apply {
            addIngredient("국수")
        },
        Food("추어탕", KOREAN).apply {
            addIngredient("미꾸라지")
        },
        Food("냉면", KOREAN).apply {
            addIngredient("메밀국수")
        },
        Food("회덮밥", KOREAN).apply {
            addIngredient("회")
        },
        Food("회", KOREAN).apply {
            addIngredient("회")
        },
        Food("꼬막비빔밥", KOREAN).apply {
            addIngredient("꼬막")
        },
        Food("감자탕", KOREAN).apply {
            addIngredient("돼지등뼈")
        },
        Food("물회", KOREAN).apply {
            addIngredient("회")
        },
        Food("과메기", KOREAN).apply {
            addIngredient("과메기")
        },
        Food("묵사발", KOREAN).apply {
            addIngredient("묵")
        },
        Food("설렁탕", KOREAN).apply {
            addIngredient("소고기")
        },
        Food("수제비", KOREAN).apply {
            addIngredient("밀가루")
        },
        Food("골뱅이무침", KOREAN).apply {
            addIngredient("골뱅이")
        },
        Food("비지찌개", KOREAN).apply {
            addIngredient("비지")
        },
        Food("홍어", KOREAN).apply {
            addIngredient("홍어")
        },
        Food("보신탕", KOREAN).apply {
            addIngredient("개고기")
        },
        Food("편육", KOREAN).apply {
            addIngredient("편육")
        },
        Food("잡채", KOREAN).apply {
            addIngredient("당면")
        },
        Food("돼지껍질", KOREAN).apply {
            addIngredient("돼지껍질")
        },
        Food("어죽", KOREAN).apply {
            addIngredient("생선")
        },
        Food("우렁쌈밥", KOREAN).apply {
            addIngredient("우렁")
        },
        Food("미역국", KOREAN).apply {
            addIngredient("미역")
        },
        Food("계란말이", KOREAN).apply {
            addIngredient("계란")
        },
        Food("두부전골", KOREAN).apply {
            addIngredient("두부")
        },

        //중식
        Food("짜장면", CHINESE).apply {
            addIngredient("춘장")
            addIngredient("면")
        },
        Food("짬뽕", CHINESE).apply {
            addIngredient("해물")
            addIngredient("면")
        },
        Food("탕수육", CHINESE).apply {
            addIngredient("돼지고기")
        },
        Food("마라탕", CHINESE).apply {
            addIngredient("마라")
        },
        Food("깐쇼새우", CHINESE).apply {
            addIngredient("새우")
        },
        Food("마파두부", CHINESE).apply {
            addIngredient("두부")
        },
        Food("양고기", CHINESE).apply {
            addIngredient("양고기")
        },
        Food("동파육", CHINESE).apply {
            addIngredient("돼지고기")
        },
        Food("깐풍기", CHINESE).apply {
            addIngredient("닭고기")
        },
        Food("꿔바로우", CHINESE).apply {
            addIngredient("돼지고기")
        },

        //일식
        Food("돈까스", JAPANESE).apply {
            addIngredient("돼지고기")
        },
        Food("라멘", JAPANESE).apply {
            addIngredient("돼지고기")
            addIngredient("면")
        },
        Food("텐동", JAPANESE).apply {
            addIngredient("밀가루")
        },
        Food("우동", JAPANESE).apply {
            addIngredient("우동면")
        },
        Food("초밥", JAPANESE).apply {
            addIngredient("회")
        },
        Food("샤부샤부", JAPANESE).apply {
            addIngredient("소고기")
        },
        Food("오므라이스", JAPANESE).apply {
            addIngredient("계란")
        },
        Food("오꼬노미야끼", JAPANESE).apply {
            addIngredient("밀가루")
        },
        Food("규동", JAPANESE).apply {
            addIngredient("소고기")
        },

        //양식
        Food("스테이크", WESTERN).apply {
            addIngredient("소고기")
        },
        Food("파스타(토마토, 크림, 오일, 로제)", WESTERN).apply {
            addIngredient("파스타")
        },
        Food("부리토", WESTERN).apply {
            addIngredient("토르티야")
            addIngredient("밥(쌀)")
        },
        Food("타코", OTHER).apply {
            addIngredient("토르티야")
        },
        Food("필라프", WESTERN).apply {
            addIngredient("밥(쌀)")
        },
        Food("리소토", WESTERN).apply {
            addIngredient("밥(쌀)")
        },
        Food("랍스타", WESTERN).apply {
            addIngredient("랍스타")
        },
        Food("샐러드", WESTERN).apply {
            addIngredient("샐러드")
        },
        Food("햄버그스테이크", WESTERN).apply {
            addIngredient("소고기")
        },
        Food("푸아그라", WESTERN).apply {
            addIngredient("거위 간")
        },
        Food("감바스", WESTERN).apply {
            addIngredient("새우")
        },
        Food("슈하스코", WESTERN).apply {
            addIngredient("고기")
        },

        //그 외
        Food("카레", OTHER).apply {
            addIngredient("카레")
        },
        Food("쌀국수", OTHER).apply {
            addIngredient("쌀국수")
        },
        Food("분짜", OTHER).apply {
            addIngredient("쌀국수")
            addIngredient("돼지고기")
        },
        Food("짜조", OTHER).apply {
            addIngredient("라이스페이퍼")
            addIngredient("돼지고기")
        },
        Food("팟타이", OTHER).apply {
            addIngredient("쌀국수")
        },
        Food("에그인헬", OTHER).apply {
            addIngredient("계란")
            addIngredient("토마토 소스")
        },
        Food("케밥", OTHER).apply {
            addIngredient("고기")
        },

        //패스트푸드
        Food("치킨", FASTFOOD).apply {
            addIngredient("닭고기")
        },
        Food("피자", FASTFOOD).apply {
            addIngredient("밀가루")
        },
        Food("햄버거", FASTFOOD).apply {
            addIngredient("햄버거빵")
        },
        Food("샌드위치", FASTFOOD).apply {
            addIngredient("식빵")
        },
        Food("토스트", FASTFOOD).apply {
            addIngredient("식빵")
        }
    )
}