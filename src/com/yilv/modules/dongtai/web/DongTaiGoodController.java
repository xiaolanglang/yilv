package com.yilv.modules.dongtai.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yilv.base.common.utils.StringUtils;
import com.yilv.base.common.web.Result;
import com.yilv.base.modules.dongtai.entity.DongTai;
import com.yilv.base.modules.dongtai.entity.DongTaiGood;
import com.yilv.common.web.BaseController;
import com.yilv.modules.dongtai.service.DongTaiGoodService;

@Controller
@RequestMapping("${travelPath}/dongtaigood")
public class DongTaiGoodController extends BaseController {
	@Autowired
	private DongTaiGoodService goodService;

	@RequestMapping("save")
	@ResponseBody
	public Object save(DongTai dongTai) {
		Result result = new Result(500);
		if (StringUtils.isEmpty(dongTai.getId())) {
			return result;
		}

		DongTaiGood good = new DongTaiGood();
		good.setDongTai(dongTai);
		goodService.good(good, result);

		return result;
	}
}
