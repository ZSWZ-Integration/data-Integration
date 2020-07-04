import { get} from './http'

/**
 * 获取选课statistic信息
 */
export const showStatisticData = () => get("/showStatisticData");

