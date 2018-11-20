package com.wemakeprice.makersmarket;

import com.wemakeprice.makersmarket.model.*;
import com.wemakeprice.makersmarket.service.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class MakersmarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(MakersmarketApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(
            ProductService productService,
            ProjectService projectService,
            @Qualifier("ProductOptionServiceImpl") OptionService productOptionService,
            @Qualifier("ProjectOptionServiceImpl") OptionService projectOptionService,
            BuyerService buyerService,
            SellerService sellerService,
            DeliveryService deliveryService,
            MessageService messageService) {
        return args -> {

            Buyer buyer = Buyer.builder().name("마켓플러스").build();

            buyerService.save(buyer);

            Seller seller1 = Seller.builder().id(1).name("네이처").intro("건강한 자연으로 만든 천연 수제간식 네이처 펫푸드").likes(1771).imageUrl("/image/seller/1/1.jpg").build();
            Seller seller2 = Seller.builder().id(2).name("장순필").intro("백리안에 장순필을 모르는 이 없게하라").likes(219).imageUrl("/image/seller/2/1.jpg").build();
            Seller seller3 = Seller.builder().id(3).name("루비즈").intro("전상품 자체제작!").likes(335).imageUrl("/image/seller/3/1.jpg").build();
            Seller seller4 = Seller.builder().id(4).name("루시아").intro("루시아 핸드메이드 캔들").likes(434).imageUrl("/image/seller/4/1.jpg").build();
            Seller seller5 = Seller.builder().id(5).name("소소").intro("작고 조그마한 공방").likes(556).imageUrl("/image/seller/5/1.jpg").build();

            sellerService.save(seller1);
            sellerService.save(seller2);
            sellerService.save(seller3);
            sellerService.save(seller4);
            sellerService.save(seller5);

            //message

            messageService.save(
                    Message.builder()
                            .contents("안녕하세요! 네이처입니다 :)\n 무엇이 궁금하신가요?")
                            .created(LocalDateTime.now())
                            .isSellerToBuyer(true)
                            .buyer(buyer)
                            .seller(seller1)
                            .build()
            );
            messageService.save(
                    Message.builder()
                            .contents("네! 물어보세요!\n")
                            .created(LocalDateTime.now().plusMinutes(6))
                            .isSellerToBuyer(true)
                            .buyer(buyer)
                            .seller(seller1)
                            .build()
            );
            messageService.save(
                    Message.builder()
                            .contents("한우 소간육포 구매하려고 하는데요!\n")
                            .created(LocalDateTime.now().plusMinutes(2))
                            .isSellerToBuyer(false)
                            .buyer(buyer)
                            .seller(seller1)
                            .build()
            );

            // Delivery
            Delivery delivery1 = Delivery.builder().name("대한통운").build();
            Delivery delivery2 = Delivery.builder().name("로젠택배").build();
            Delivery delivery3 = Delivery.builder().name("한진택배").build();

            deliveryService.save(delivery1);
            deliveryService.save(delivery2);
            deliveryService.save(delivery3);


            // Product
            Product product1 = Product.builder()
                    .name("휴먼 그레이드급 원료로 만든 수제간식")
                    .price(990)
                    .intro("건강하개 맛있개 1+1")
                    .likes(72)
                    .start(LocalDate.of(2018, 10, 10))
                    .finish(LocalDate.of(2018, 11, 11))
                    .sales(3858)
                    .remain(1142)
                    .seller(seller1)
                    .delivery(delivery1)
                    .mainImageUrl(new String[]{"/image/product/main/1/1.jpg"})
                    .detailsImageUrl(new String[]{
                            "/image/product/detail/1/1.jpg",
                            "/image/product/detail/1/2.jpg",
                            "/image/product/detail/1/3.jpg",
                            "/image/product/detail/1/4.jpg"
                    })
                    .build();

            Product product2 = Product.builder()
                    .name("장순필 수제 브라우니")
                    .price(18900)
                    .intro("쫀득쫀득 촉촉한 초콜렛..!")
                    .likes(29)
                    .start(LocalDate.of(2018, 10, 10))
                    .finish(LocalDate.of(2018, 11, 11))
                    .sales(4190)
                    .remain(810)
                    .seller(seller2)
                    .delivery(delivery2)
                    .mainImageUrl(new String[]{"/image/product/main/2/1.jpg"})
                    .detailsImageUrl(new String[]{
                            "/image/product/detail/2/1.jpg",
                            "/image/product/detail/2/2.jpg",
                            "/image/product/detail/2/3.jpg",
                            "/image/product/detail/2/4.jpg"
                    })
                    .build();

            Product product3 = Product.builder()
                    .name("삼각 프리미엄 큐티 하우스")
                    .price(29900)
                    .intro("간편조립, 접이식 보관편리")
                    .likes(3)
                    .start(LocalDate.of(2018, 10, 10))
                    .finish(LocalDate.of(2018, 11, 11))
                    .sales(8)
                    .remain(92)
                    .seller(seller1)
                    .delivery(delivery3)
                    .mainImageUrl(new String[]{
                            "/image/product/main/3/1.jpg",
                            "/image/product/main/3/2.jpg"
                    })
                    .detailsImageUrl(new String[]{
                            "/image/product/detail/3/1.jpg",
                            "/image/product/detail/3/2.jpg"
                    })
                    .build();

            Product product4 = Product.builder()
                    .name("악세사리/주얼리 보관함")
                    .price(22800)
                    .intro("다용도 수납공간!")
                    .likes(21)
                    .start(LocalDate.of(2018, 10, 10))
                    .finish(LocalDate.of(2018, 11, 11))
                    .sales(52)
                    .remain(148)
                    .seller(seller5)
                    .delivery(delivery3)
                    .mainImageUrl(new String[]{
                            "/image/product/main/4/1.jpg"
                    })
                    .detailsImageUrl(new String[]{
                            "/image/product/detail/4/1.jpg",
                            "/image/product/detail/4/2.jpg",
                            "/image/product/detail/4/3.jpg"
                    })
                    .build();

            Product product5 = Product.builder()
                    .name("데일리 패션팔찌")
                    .price(1000)
                    .intro("허전한 손목에 포인트를")
                    .likes(1228)
                    .start(LocalDate.of(2018, 10, 10))
                    .finish(LocalDate.of(2018, 11, 11))
                    .sales(7704)
                    .remain(2296)
                    .seller(seller5)
                    .delivery(delivery2)
                    .mainImageUrl(new String[]{
                            "/image/product/main/5/1.jpg",
                            "/image/product/main/5/2.jpg"
                    })
                    .detailsImageUrl(new String[]{
                            "/image/product/detail/5/1.jpg",
                            "/image/product/detail/5/2.jpg",
                            "/image/product/detail/5/3.jpg",
                            "/image/product/detail/5/4.jpg"
                    })
                    .build();

            productService.save(product1);
            productService.save(product2);
            productService.save(product3);
            productService.save(product4);
            productService.save(product5);

            ProductOption productOption011 = ProductOption.builder().name("01. 한우 소간육포").additionalPrice(1900).product(product1).build();
            ProductOption productOption012 = ProductOption.builder().name("02. 한우 소허파육포").additionalPrice(1900).product(product1).build();
            ProductOption productOption013 = ProductOption.builder().name("03. 닭근위 육포").additionalPrice(2900).product(product1).build();
            ProductOption productOption021 = ProductOption.builder().name("01. [특가] 수제 브라우니 6팩").additionalPrice(0).product(product2).build();
            ProductOption productOption022 = ProductOption.builder().name("02. 수제 브라우니 5팩").additionalPrice(2000).product(product2).build();
            ProductOption productOption023 = ProductOption.builder().name("03. 수제 브라우니 10팩").additionalPrice(21000).product(product2).build();
            ProductOption productOption31 = ProductOption.builder().name("삼각 프리미엄 큐티하우스").additionalPrice(0).product(product3).build();
            ProductOption productOption41 = ProductOption.builder().name("01. 베이직 2단 보석함").additionalPrice(0).product(product4).build();
            ProductOption productOption42 = ProductOption.builder().name("02. 가죽 2단 보석함").additionalPrice(7000).product(product4).build();
            ProductOption productOption51 = ProductOption.builder().name("01. 믹스비즈 뜨게팔찌").additionalPrice(0).product(product5).build();
            ProductOption productOption52 = ProductOption.builder().name("02. 스타구슬팔찌").additionalPrice(0).product(product5).build();

            productOptionService.save(productOption011);
            productOptionService.save(productOption012);
            productOptionService.save(productOption013);
            productOptionService.save(productOption021);
            productOptionService.save(productOption022);
            productOptionService.save(productOption023);
            productOptionService.save(productOption31);
            productOptionService.save(productOption41);
            productOptionService.save(productOption42);
            productOptionService.save(productOption51);
            productOptionService.save(productOption52);

            // Project
            Project project1 = Project.builder()
                    .name("루비즈 유아 헤어핀/헤어밴드/ACC")
                    .price(990)
                    .intro("루비즈 빠른발송 + 사은품 증정")
                    .likes(19)
                    .start(LocalDate.of(2018, 10, 10))
                    .finish(LocalDate.of(2018, 11, 11))
                    .dDay(10)
                    .rate(89)
                    .sponsorCnt(89)
                    .sponAmount(890000)
                    .sponTarget(1000000)
                    .seller(seller3)
                    .delivery(delivery1)
                    .mainImageUrl(new String[]{
                            "/image/project/main/1/1.jpg",
                            "/image/project/main/1/2.jpg",
                            "/image/project/main/1/3.jpg"
                    })
                    .detailsImageUrl(new String[]{
                            "/image/project/detail/1/1.jpg",
                            "/image/project/detail/1/2.jpg",
                            "/image/project/detail/1/3.jpg",
                            "/image/project/detail/1/4.jpg",
                            "/image/project/detail/1/5.jpg",
                            "/image/project/detail/1/6.jpg"
                    })
                    .build();

            Project project2 = Project.builder()
                    .name("천연 수제 바구니")
                    .price(7800)
                    .intro("정성스러운 수작업으로 탄생한")
                    .likes(22)
                    .start(LocalDate.of(2018, 10, 10))
                    .finish(LocalDate.of(2018, 11, 11))
                    .dDay(10)
                    .rate(78)
                    .sponsorCnt(100)
                    .sponAmount(780000)
                    .sponTarget(1000000)
                    .seller(seller3)
                    .delivery(delivery1)
                    .mainImageUrl(new String[]{
                            "/image/project/main/2/1.jpg",
                    })
                    .detailsImageUrl(new String[]{
                            "/image/project/detail/2/1.jpg",
                            "/image/project/detail/2/2.jpg",
                            "/image/project/detail/2/3.jpg",
                            "/image/project/detail/2/4.jpg",
                            "/image/project/detail/2/5.jpg"
                    })
                    .build();

            Project project3 = Project.builder()
                    .name("루시아 프리미엄 소이캔들")
                    .price(34000)
                    .intro("루시아만의 고급스러운 명품향. 직접 경험해보세요.")
                    .likes(55)
                    .start(LocalDate.of(2018, 10, 10))
                    .finish(LocalDate.of(2018, 11, 11))
                    .dDay(10)
                    .rate(34)
                    .sponsorCnt(10)
                    .sponAmount(340000)
                    .sponTarget(1000000)
                    .seller(seller4)
                    .delivery(delivery2)
                    .mainImageUrl(new String[]{
                            "/image/project/main/3/1.jpg",
                            "/image/project/main/3/2.jpg"
                    })
                    .detailsImageUrl(new String[]{
                            "/image/project/detail/3/1.jpg",
                            "/image/project/detail/3/2.jpg",
                            "/image/project/detail/3/3.jpg"
                    })
                    .build();

            Project project4 = Project.builder()
                    .name("인테리어 Cotton 수제 카페트")
                    .price(35900)
                    .intro("수제 카페트 떳다!!")
                    .likes(36)
                    .start(LocalDate.of(2018, 10, 10))
                    .finish(LocalDate.of(2018, 11, 11))
                    .dDay(10)
                    .rate(35)
                    .sponsorCnt(10)
                    .sponAmount(359000)
                    .sponTarget(1000000)
                    .seller(seller3)
                    .delivery(delivery2)
                    .mainImageUrl(new String[]{
                            "/image/project/main/4/1.jpg"
                    })
                    .detailsImageUrl(new String[]{
                            "/image/project/detail/4/1.jpg",
                            "/image/project/detail/4/2.jpg"
                    })
                    .build();

            Project project5 = Project.builder()
                    .name("신선한 과일 수제청")
                    .price(9900)
                    .intro("100% 수제 신선한 과일 수제청")
                    .likes(171)
                    .start(LocalDate.of(2018, 10, 10))
                    .finish(LocalDate.of(2018, 11, 11))
                    .dDay(10)
                    .rate(99)
                    .sponsorCnt(100)
                    .sponAmount(990000)
                    .sponTarget(1000000)
                    .seller(seller2)
                    .delivery(delivery2)
                    .mainImageUrl(new String[]{
                            "/image/project/main/5/1.jpg",
                            "/image/project/main/5/2.jpg"
                    })
                    .detailsImageUrl(new String[]{
                            "/image/project/detail/5/1.jpg",
                            "/image/project/detail/5/2.jpg",
                            "/image/project/detail/5/3.jpg"
                    })
                    .build();

            projectService.save(project1);
            projectService.save(project2);
            projectService.save(project3);
            projectService.save(project4);
            projectService.save(project5);

            ProjectOption projectOption011 = ProjectOption.builder().name("1. 실리콘 고무줄").additionalPrice(0).project(project1).build();
            ProjectOption projectOption012 = ProjectOption.builder().name("2. 페이즐리 터번&반다나").additionalPrice(4810).project(project1).build();
            ProjectOption projectOption021 = ProjectOption.builder().name("1. 원형손잡이바구니").additionalPrice(0).project(project2).build();
            ProjectOption projectOption022 = ProjectOption.builder().name("2. 사각바구니").additionalPrice(1000).project(project2).build();
            ProjectOption projectOption031 = ProjectOption.builder().name("1. 러브미 향").additionalPrice(0).project(project3).build();
            ProjectOption projectOption032 = ProjectOption.builder().name("2. 메리미 향").additionalPrice(0).project(project3).build();
            ProjectOption projectOption041 = ProjectOption.builder().name("1. 무지").additionalPrice(0).project(project4).build();
            ProjectOption projectOption042 = ProjectOption.builder().name("2. 디자인").additionalPrice(0).project(project4).build();
            ProjectOption projectOption051 = ProjectOption.builder().name("1. 딸기청").additionalPrice(0).project(project5).build();
            ProjectOption projectOption052 = ProjectOption.builder().name("2. 레몬청").additionalPrice(1000).project(project5).build();

            projectOptionService.save(projectOption011);
            projectOptionService.save(projectOption012);
            projectOptionService.save(projectOption021);
            projectOptionService.save(projectOption022);
            projectOptionService.save(projectOption031);
            projectOptionService.save(projectOption032);
            projectOptionService.save(projectOption041);
            projectOptionService.save(projectOption042);
            projectOptionService.save(projectOption051);
            projectOptionService.save(projectOption052);

        };
    }
}
