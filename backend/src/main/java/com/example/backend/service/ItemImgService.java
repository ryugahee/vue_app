package com.example.backend.service;

import com.example.backend.entity.ItemImg;
import com.example.backend.repository.ItemImgRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemImgService {

    private final ItemImgRepository itemImgRepository;

    private final FileService fileService;

    public String makeDir() {

        String folderPath = "C:\\auction\\item";

        File makeFolder = new File(folderPath);

        if(!makeFolder.exists()) {

            makeFolder.mkdirs();
            System.out.println("폴더를 생성합니다.");

        } else {
            System.out.println("이미 해당 폴더가 존재합니다.");
        }
        return folderPath;
    }

    public void saveItemImg(ItemImg itemImg, MultipartFile itemImgFile) throws Exception {
        String oriImgName = itemImgFile.getOriginalFilename();
        String imgName = "";
        String imgUrl = "";

        String itemImgLocation = makeDir();

        //파일 업로드
        if (!StringUtils.isEmpty(oriImgName)) {
            // 사용자가 상품 이미지 등록시 저장할 경로, 파일 이름, 파일 바이트 배열을 업로드 파라미터로 uploadFile()메소드 호출 후 imgName 변수에 저장
            imgName = fileService.uploadFile(itemImgLocation, oriImgName, itemImgFile.getBytes());
            imgUrl = "/imges/item/" + imgName;  //저장한 상품 불러올 경로 설정
        }

        // 상품 이미지 정보 저장
        // 실제 저장된 파일 이름, 업로드했던 파일 원래 이름, 업로드 결과 로컬에 저장된 파일 불러오는 경로
        itemImg.updateItemImg(oriImgName, imgName, imgUrl);
        itemImgRepository.save(itemImg);
    }

}
