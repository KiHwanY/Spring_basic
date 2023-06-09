package com.example.spring.service.chart;

import java.awt.Color;

import java.awt.Font;
import java.util.List;

import javax.inject.Inject;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Service;

import com.example.spring.model.shop.dao.CartDAO;
import com.example.spring.model.shop.dto.CartDTO;
import com.mysql.cj.x.protobuf.MysqlxCrud.CollectionOrBuilder;

@Service
public class JFreeChartServiceImpl implements JFreeChartService {
	
	@Inject
	CartDAO cartDao;

	@Override
	public JFreeChart createChart() {
		//장바구니 상품 목록
		List<CartDTO> list=cartDao.cartMoeny();
		
		//차트에 입력할 데이터셋 객체(파이차트가 아닌 경우)
//		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
//		for(CartDTO dto : list) {
//			dataset.setValue(dto.getMoney(), "과일", dto.getProduct_name());
//		
//		}
		
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(CartDTO dto : list) {
			dataset.setValue(dto.getProduct_name(), dto.getMoney());
		}
		
		//차트 객체
		JFreeChart chart=null;
		String title="장바구니 통계"; //차트 제목
		try {
			//createBarChart(제목,x축라벨,y축라벨,dataset,그래프방향, 범례, 툴팁, url);
//			chart=ChartFactory.createBarChart(title, "상품명", "금액", 
//					dataset, PlotOrientation.VERTICAL, true, true, false);
			
//			chart=ChartFactory.createLineChart(title, "상품명", "금액", 
//					dataset, PlotOrientation.VERTICAL, true, true, false);
			
			chart=ChartFactory.createPieChart(title, dataset, true, true, false);
			
			
			//차트 제목 폰트
			chart.getTitle().setFont(new Font("돋움",Font.BOLD,15));
			//범례 폰트
			chart.getLegend().setItemFont(new Font("돋움",Font.PLAIN, 10));
			Font font=new Font("돋움", Font.PLAIN, 12);//기본 폰트지정
			Color color=new Color(0,0,0);//black
			StandardChartTheme chartTheme=
					(StandardChartTheme)StandardChartTheme.createJFreeTheme();
			chartTheme.setExtraLargeFont(font);
			chartTheme.setLargeFont(font);
			chartTheme.setRegularFont(font);
			chartTheme.setSmallFont(font);
			chartTheme.setAxisLabelPaint(color);//x,y축 글자라벨
			chartTheme.setLegendItemPaint(color);
			chartTheme.setItemLabelPaint(color);
			//폰트,컬러를 차트에 적용
			chartTheme.apply(chart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chart;
	}
}
