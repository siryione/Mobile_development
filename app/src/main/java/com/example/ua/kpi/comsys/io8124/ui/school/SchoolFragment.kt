package com.example.ua.kpi.comsys.io8124.ui.school

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ua.kpi.comsys.io8124.R
import com.intrusoft.scatter.ChartData
import com.intrusoft.scatter.PieChart
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import kotlin.math.E
import kotlin.math.pow


class SchoolFragment : Fragment() {

    private lateinit var graph: GraphView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_school, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        init()
        drawGraph()
        drawPieChart()
    }


    private fun init() {
        graph = requireView().findViewById(R.id.graph)
    }

    private fun drawPieChart() {
        val pieChart = requireView().findViewById(R.id.pie_chart) as PieChart
        val data = ArrayList<ChartData>()
        data.add(ChartData("Black 40%", 40f, Color.WHITE, Color.BLACK))
        data.add(ChartData("Orange 30%", 30f, Color.WHITE, Color.parseColor("#FFA500")))
        data.add(ChartData("Green 30%", 30f, Color.WHITE, Color.GREEN))
        pieChart.setChartData(data)
    }

    private fun drawGraph() {
        val start = -6.0
        val end = 6.0
        val maxPoints = 100
        val arrOfX: DoubleArray = funcX()
        val arrOfY = DoubleArray(maxPoints) { expFun(arrOfX[it]) }
        val series = LineGraphSeries<DataPoint>()

        for (i in 0 until maxPoints)
            series.appendData(DataPoint(arrOfX[i], arrOfY[i]), false, arrOfX.size)

        graph.viewport.isXAxisBoundsManual = true
        graph.viewport.setMaxX(end)
        graph.viewport.setMinX(start)
        graph.viewport.isYAxisBoundsManual = true
        graph.viewport.setMaxY(250.0)
        graph.viewport.setMinY(-10.0)
        graph.addSeries(series)
    }

    private fun expFun(x: Double) = E.pow(x)

    private fun funcX() =
        DoubleArray(100) { -6.0 + it * ((6.0 - (-6.0)) / (100 - 1)) }
}
