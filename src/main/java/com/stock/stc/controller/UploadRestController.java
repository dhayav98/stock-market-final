package com.stock.stc.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.stock.stc.dao.*;
import com.stock.stc.model.StockPrice;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UploadRestController {
	@Autowired
	StockPriceDao stockPriceDao;

	@PostMapping("/upload")
	public List<StockPrice> upload(@RequestParam("file") MultipartFile file) throws Exception {
		Path tempDir = Files.createTempDirectory("");

		File tempFile = tempDir.resolve(file.getOriginalFilename()).toFile();

		file.transferTo(tempFile);

		Workbook workbook = WorkbookFactory.create(tempFile);

		Sheet sheet = workbook.getSheetAt(0);
		DataFormatter dataFormatter = new DataFormatter();
		List<StockPrice> list = new ArrayList<>();
		System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
		int flag = 0;
		for (Row row : sheet) {
			int i = 0;
			System.out.println(row.getRowNum());
			if (row.getRowNum() > 0) {
				StockPrice stockPrice = new StockPrice();
				for (Cell cell : row) {
					String cellValue = dataFormatter.formatCellValue(cell);
					System.out.println(cellValue);
					if (cellValue.equals("")) {
						flag = 1;
						break;
					}
					i++;
					switch (i) {

					case 1:
						int companyId = (int) Double.parseDouble(cellValue);
						stockPrice.setCompanyId(companyId);
						break;
					case 2:
						double price = Double.parseDouble(cellValue);
						stockPrice.setCurrentPrice(price);
						break;
					case 3:
						String stockEx = cellValue;
						stockPrice.setStockExchange(stockEx);
						break;
					case 4:
						Date date = cell.getDateCellValue();
						stockPrice.setDate(date);
						break;

					}
//				System.out.println(cellValue);
				}
				if (flag == 1)
					break;
				stockPriceDao.save(stockPrice);
				list.add(stockPrice);
				System.out.println();
			}
		}
		return list;
	}
}
